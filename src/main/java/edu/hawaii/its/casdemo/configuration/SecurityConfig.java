package edu.hawaii.its.casdemo.configuration;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.proxy.ProxyGrantingTicketStorage;
import org.jasig.cas.client.proxy.ProxyGrantingTicketStorageImpl;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.validation.Saml11TicketValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.cas.web.authentication.ServiceAuthenticationDetailsSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.util.Assert;

import edu.hawaii.its.casdemo.access.CasUserDetailsService;
import edu.hawaii.its.casdemo.access.DelegatingAuthenticationFailureHandler;
import edu.hawaii.its.casdemo.access.UserBuilder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Log logger = LogFactory.getLog(SecurityConfig.class);

    @Value("${app.url.base}")
    private String appUrlBase;

    @Value("${app.url.home}")
    private String appUrlHome;

    @Value("${app.url.error-login}")
    private String appUrlError;

    @Value("${cas.login.url}")
    private String casLoginUrl;

    @Value("${cas.mainUrl}")
    private String casMainUrl;

    @Autowired
    private UserBuilder userBuilder;

    @PostConstruct
    public void init() {
        logger.info("SecurityConfig starting...");

        logger.info("   appUrlHome: " + appUrlHome);
        logger.info("   appUrlBase: " + appUrlBase);
        logger.info("  appUrlError: " + appUrlError);
        logger.info("   casMainUrl: " + casMainUrl);
        logger.info("  casLoginUrl: " + casLoginUrl);
        logger.info("  userBuilder: " + userBuilder);

        Assert.hasLength(appUrlHome, "property 'appUrlHome' is required");
        Assert.hasLength(appUrlBase, "property 'appUrlBase' is required");
        Assert.hasLength(appUrlError, "property 'appUrlError' is required");
        Assert.hasLength(casMainUrl, "property 'casMainUrl' is required");
        Assert.hasLength(casLoginUrl, "property 'casLoginUrl' is required");

        logger.info("SecurityConfig started.");
    }

    @Bean
    public ProxyGrantingTicketStorage proxyGrantingTicketStorage() {
        return new ProxyGrantingTicketStorageImpl();
    }

    @Bean
    @ConfigurationProperties(prefix = "cas")
    public ServiceProperties serviceProperties() {
        return new ServiceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "cas.saml")
    public Saml11TicketValidator saml11TicketValidator() {
        return new Saml11TicketValidator(casMainUrl);
    }

    @Bean
    public CasAuthenticationEntryPoint casAuthenticationEntryPoint() {
        CasAuthenticationEntryPoint entryPoint = new CasAuthenticationEntryPoint();
        entryPoint.setLoginUrl(casLoginUrl);
        entryPoint.setServiceProperties(serviceProperties());
        return entryPoint;
    }

    @Bean
    public SingleSignOutFilter singleSignOutFilter() {
        return new SingleSignOutFilter();
    }

    @Bean
    public CasAuthenticationProvider casAuthenticationProvider() {
        CasAuthenticationProvider provider = new CasAuthenticationProvider();
        provider.setKey("an_id_for_this_auth_provider_only");
        provider.setAuthenticationUserDetailsService(authenticationUserDetailsService());
        provider.setServiceProperties(serviceProperties());
        provider.setTicketValidator(saml11TicketValidator());
        return provider;
    }

    @Bean
    public AuthenticationUserDetailsService<CasAssertionAuthenticationToken> authenticationUserDetailsService() {
        return new CasUserDetailsService(userBuilder);
    }

    @Bean
    public CasAuthenticationFilter casAuthenticationFilter() throws Exception {
        CasAuthenticationFilter filter = new CasAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager());

        filter.setProxyAuthenticationFailureHandler(authenticationFailureHandler());
        filter.setAuthenticationFailureHandler(authenticationFailureHandler());

        filter.setAuthenticationSuccessHandler(authenticationSuccessHandler());

        ServiceAuthenticationDetailsSource authenticationDetailsSource =
                new ServiceAuthenticationDetailsSource(serviceProperties());
        filter.setAuthenticationDetailsSource(authenticationDetailsSource);

        filter.setProxyGrantingTicketStorage(proxyGrantingTicketStorage());
        filter.setProxyReceptorUrl("/receptor");
        filter.setServiceProperties(serviceProperties());

        return filter;
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        SavedRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler =
                new SavedRequestAwareAuthenticationSuccessHandler();
        authenticationSuccessHandler.setAlwaysUseDefaultTargetUrl(false);
        authenticationSuccessHandler.setDefaultTargetUrl(appUrlHome);
        return authenticationSuccessHandler;
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new DelegatingAuthenticationFailureHandler(appUrlError);
    }

    @Bean
    public SecurityContextLogoutHandler securityContextLogoutHandler() {
        return new SecurityContextLogoutHandler();
    }

    @Bean
    public LogoutFilter logoutFilter() {
        return new LogoutFilter(appUrlHome, securityContextLogoutHandler());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/**").authenticated()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/fonts/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/javascript/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/campus", "/campuses").authenticated()
                .antMatchers("/contact").permitAll()
                .antMatchers("/error").permitAll()
                .antMatchers("/error-login").permitAll()
                .antMatchers("/home").permitAll()
                .antMatchers("/help/**").permitAll()
                .antMatchers("/404").permitAll()
                .antMatchers("/holiday", "/holidays").hasRole("ADMIN")
                .antMatchers("/holidaygrid").hasRole("ADMIN")
                .antMatchers("/holidaysgrid").hasRole("ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user").hasRole("USER")
                .antMatchers("/user/data").hasRole("USER")
                .antMatchers("/feedback").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .addFilter(casAuthenticationFilter())
                .addFilterBefore(logoutFilter(), LogoutFilter.class)
                .addFilterBefore(singleSignOutFilter(), CasAuthenticationFilter.class)
                .exceptionHandling().authenticationEntryPoint(casAuthenticationEntryPoint())
                .and()
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutUrl("/logout").permitAll()
                .logoutSuccessUrl(appUrlHome);
    }

}

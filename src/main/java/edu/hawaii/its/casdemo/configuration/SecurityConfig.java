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
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.cas.web.authentication.ServiceAuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.util.Assert;

import edu.hawaii.its.casdemo.access.UserBuilder;
import edu.hawaii.its.casdemo.access.UserDetailsServiceImpl;

@ComponentScan(basePackages = "edu.hawaii.its.casdemo")
@ConfigurationProperties(prefix = "cas")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Log logger = LogFactory.getLog(SecurityConfig.class);

    @Value("${url.home}")
    private String homeUrl;

    @Value("${url.base}")
    private String urlBase;

    @Value("${cas.login.url}")
    private String casLoginUrl;

    @Value("${cas.logout.url}")
    private String casLogoutUrl;

    @Value("${cas.main.url}")
    private String casMainUrl;

    @Value("${cas.saml.tolerance}")
    private long casSamlTolerance;

    @Value("${cas.send.renew}")
    private boolean casSendRenew;

    @Autowired
    private UserBuilder userBuilder;

    @PostConstruct
    public void init() {
        Assert.hasLength(homeUrl, "property 'homeUrl' is required");
        Assert.hasLength(urlBase, "property 'urlBase' is required");
        Assert.hasLength(casLoginUrl, "property 'casLoginUrl' is required");
        Assert.hasLength(casLogoutUrl, "property 'casLogoutUrl' is required");

        logger.info("urlBase: " + urlBase);
        logger.info("casLoginUrl: " + casLoginUrl);
        logger.info("casLogoutUrl: " + casLogoutUrl);
        logger.info("casSendRenew: " + casSendRenew);
    }

    private ProxyGrantingTicketStorage proxyGrantingTicketStorage() {
        return new ProxyGrantingTicketStorageImpl();
    }

    private ServiceProperties serviceProperties() {
        ServiceProperties serviceProperties = new ServiceProperties();
        serviceProperties.setService(urlBase + "/login/cas");
        serviceProperties.setSendRenew(casSendRenew);
        serviceProperties.setAuthenticateAllArtifacts(true);

        return serviceProperties;
    }

    private CasAuthenticationEntryPoint casAuthenticationEntryPoint() {
        CasAuthenticationEntryPoint entryPoint = new CasAuthenticationEntryPoint();
        entryPoint.setLoginUrl(casLoginUrl);
        entryPoint.setServiceProperties(serviceProperties());
        return entryPoint;
    }

    private SingleSignOutFilter singleSignOutFilter() {
        SingleSignOutFilter filter = new SingleSignOutFilter();
        filter.setCasServerUrlPrefix(casMainUrl);

        return filter;
    }

    private CasAuthenticationProvider casAuthenticationProvider() {
        CasAuthenticationProvider provider = new CasAuthenticationProvider();
        provider.setKey("an_id_for_this_auth_provider_only");
        provider.setAuthenticationUserDetailsService(authenticationUserDetailsService());
        provider.setServiceProperties(serviceProperties());

        Saml11TicketValidator ticketValidator = new Saml11TicketValidator(casMainUrl);
        ticketValidator.setTolerance(casSamlTolerance);
        provider.setTicketValidator(ticketValidator);

        return provider;
    }

    private AuthenticationUserDetailsService<CasAssertionAuthenticationToken> authenticationUserDetailsService() {
        return new UserDetailsServiceImpl(userBuilder);
    }

    private CasAuthenticationFilter casAuthenticationFilter() throws Exception {
        CasAuthenticationFilter filter = new CasAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager());

        SimpleUrlAuthenticationFailureHandler authenticationFailureHandler =
                new SimpleUrlAuthenticationFailureHandler();
        authenticationFailureHandler.setDefaultFailureUrl(homeUrl);
        filter.setAuthenticationFailureHandler(authenticationFailureHandler);

        SavedRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler =
                new SavedRequestAwareAuthenticationSuccessHandler();
        authenticationSuccessHandler.setAlwaysUseDefaultTargetUrl(false);
        authenticationSuccessHandler.setDefaultTargetUrl(homeUrl);
        filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);

        ServiceAuthenticationDetailsSource authenticationDetailsSource =
                new ServiceAuthenticationDetailsSource(serviceProperties());
        filter.setAuthenticationDetailsSource(authenticationDetailsSource);

        filter.setProxyGrantingTicketStorage(proxyGrantingTicketStorage());
        filter.setProxyReceptorUrl("/receptor");
        filter.setServiceProperties(serviceProperties());

        return filter;
    }

    public SecurityContextLogoutHandler securityContextLogoutHandler() {
        return new SecurityContextLogoutHandler();
    }

    public LogoutFilter logoutFilter() {
        return new LogoutFilter(homeUrl, securityContextLogoutHandler());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.exceptionHandling().authenticationEntryPoint(casAuthenticationEntryPoint());

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/**").authenticated()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/fonts/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/javascript/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/campus").permitAll()
                .antMatchers("/campuses").permitAll()
                .antMatchers("/contact").permitAll()
                .antMatchers("/home").permitAll()
                .antMatchers("/help/**").permitAll()
                .antMatchers("/404").permitAll()
                .antMatchers("/holiday").hasRole("ADMIN")
                .antMatchers("/holidays").hasRole("ADMIN")
                .antMatchers("/holidaygrid").hasRole("ADMIN")
                .antMatchers("/holidaysgrid").hasRole("ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .addFilter(casAuthenticationFilter())
                .addFilterBefore(logoutFilter(), LogoutFilter.class)
                .addFilterBefore(singleSignOutFilter(), CasAuthenticationFilter.class)
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutUrl("/logout").permitAll()
                .logoutSuccessUrl(homeUrl);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(casAuthenticationProvider());
    }

}
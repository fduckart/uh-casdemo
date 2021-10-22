package edu.hawaii.its.casdemo.access;

import java.util.Map;
import java.util.Objects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.security.cas.userdetails.AbstractCasAssertionUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CasUserDetailsService extends AbstractCasAssertionUserDetailsService {

    private static final Log logger = LogFactory.getLog(CasUserDetailsService.class);

    private final UserBuilder userBuilder;

    // Constructor.
    public CasUserDetailsService(UserBuilder userBuilder) {
        super();
        Objects.requireNonNull(userBuilder, "UserBuilder cannot be null.");
        this.userBuilder = userBuilder;
    }

    @Override
    protected UserDetails loadUserDetails(Assertion assertion) {
        if (assertion.getPrincipal() == null) {
            // Not sure this is possible.
            throw new UsernameNotFoundException("principal is null");
        }
        String username = assertion.getPrincipal().getName();
        logger.debug("principal.name: " + username);

        Map<String, Object> map = assertion.getPrincipal().getAttributes();
        logger.info("map: " + map);

        return userBuilder.make(new UhCasAttributes(username, map));
    }

    @Override
    public String toString() {
        return "CasUserDetailsService [userBuilder=" + userBuilder + "]";
    }

}

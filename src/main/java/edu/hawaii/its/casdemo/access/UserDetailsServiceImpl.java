package edu.hawaii.its.casdemo.access;

import java.util.Map;
import org.jasig.cas.client.validation.Assertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.cas.userdetails.AbstractCasAssertionUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("casdemoUserDetailsService")
@Transactional(readOnly = true)
public class UserDetailsServiceImpl extends AbstractCasAssertionUserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserBuilder userBuilder;

    @Override
    protected UserDetails loadUserDetails(Assertion assertion) {
        if (assertion.getPrincipal() == null) {
            // Not sure this is possible.
            throw new UsernameNotFoundException("principal is null");
        }

        String username = assertion.getPrincipal().getName();
        if (username == null || username.trim().length() == 0) {
            // Not sure this possible, either.
            throw new UsernameNotFoundException("username is null or empty");
        }

        Map<Object, Object> map = assertion.getPrincipal().getAttributes();
        if (logger.isDebugEnabled()) {
            logger.debug("map: " + map);
        }

        return userBuilder.make(new UhCasAttributes(map));
    }

}

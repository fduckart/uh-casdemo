package edu.hawaii.its.casdemo.access;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.cas.userdetails.AbstractCasAssertionUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional
public class CasUserDetailsService extends AbstractCasAssertionUserDetailsService {

    private static final Log logger = LogFactory.getLog(CasUserDetailsService.class);

    @Autowired
    private UserBuilder userBuilder;

    // Constructor.
    public CasUserDetailsService(@Autowired UserBuilder userBuilder) {
        super();
        this.userBuilder = userBuilder;
    }

    @PostConstruct
    public void init() {
        logger.info("init; starting...");
        logger.info("  userBuilder       : " + userBuilder);
        Assert.notNull(userBuilder, "Property 'userBuilder' not set.");
        logger.info("init; started.");
    }

    @Override
    protected UserDetails loadUserDetails(Assertion assertion) {
        if (assertion.getPrincipal() == null) {
            // Not sure this is possible.
            throw new UsernameNotFoundException("principal is null");
        }

        Map<String, Object> map = assertion.getPrincipal().getAttributes();
        logger.info("map: " + map);

        return userBuilder.make(new UhCasAttributes(map));
    }

    @Override
    public String toString() {
        return "CasUserDetailsService [userBuilder=" + userBuilder + "]";
    }

}

package edu.hawaii.its.casdemo.access;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.hawaii.its.casdemo.util.Strings;

@Service
public final class UserBuilder {

    private static final Log logger = LogFactory.getLog(UserBuilder.class);

    @Autowired
    private AuthorizationService authorizationService;

    public synchronized User make(UhAttributes attributes) {
        String username = attributes.getUsername();
        if (Strings.isBlank(username)) {
            // Should not happen, but just in case.
            throw new UsernameNotFoundException("username is blank");
        }

        logger.debug("Lookup roles for user via service.");
        String uhuuid = attributes.getUhUuid();
        RoleHolder roleHolder = authorizationService.fetchRoles(uhuuid);

        logger.info("Adding roles. username: " + username + "; roles: " + roleHolder.getAuthorites());
        User user = new User(username, uhuuid, roleHolder.getAuthorites());
        logger.debug("Done adding roles; username: " + username);

        // Put all the attributes into the user
        // object just for the demonstration.
        // Above is what might commonly occur.
        user.setAttributes(attributes);

        return user;
    }

}

package edu.hawaii.its.casdemo.access;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserContextService {

    public User getCurrentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                return (User) principal;
            }
        }
        return anonymousUser;
    }

    public String getCurrentUsername() {
        return getCurrentUser().getUsername();
    }

    public String getCurrentUhuuid() {
        return getCurrentUser().getUhuuid();
    }

    @Override
    public String toString() {
        return "UserContextServiceImpl [context=" + SecurityContextHolder.getContext() + "]";
    }

    // ------------------------------------------------------------------------
    static final User anonymousUser;
    static final Set<GrantedAuthority> authorities = new LinkedHashSet<>();
    static {
        authorities.add(new SimpleGrantedAuthority(Role.ANONYMOUS.longName()));
        anonymousUser = new User.Builder()
                .username("anonymous")
                .authorities(Collections.unmodifiableCollection(authorities))
                .attributes(new UhCasAttributes())
                .create();
    }
}

package edu.hawaii.its.casdemo.controller;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import edu.hawaii.its.casdemo.access.UhAttributes;
import edu.hawaii.its.casdemo.access.UhCasAttributes;
import edu.hawaii.its.casdemo.access.User;

public class WithMockUserSecurityContextFactory
        implements WithSecurityContextFactory<WithMockUhUser> {

    @Override
    public SecurityContext createSecurityContext(WithMockUhUser uhUser) {
        Set<GrantedAuthority> authorities = new LinkedHashSet<>();
        for (String role : uhUser.roles()) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        Map<String, String> attrsMap = new HashMap<>();
        attrsMap.put("displayName", uhUser.name());
        UhAttributes attributes = new UhCasAttributes(attrsMap);
        User user = new User.Builder()
                .username(uhUser.username())
                .uhuuid(uhUser.uhuuid())
                .authorities(authorities)
                .attributes(attributes)
                .create();

        final Authentication auth =
                new UsernamePasswordAuthenticationToken(user, "pw", user.getAuthorities());

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(auth);

        return context;
    }

}
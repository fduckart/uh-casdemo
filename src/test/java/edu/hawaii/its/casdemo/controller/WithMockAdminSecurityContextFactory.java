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

public class WithMockAdminSecurityContextFactory
        implements WithSecurityContextFactory<WithMockUhAdmin> {

    @Override
    public SecurityContext createSecurityContext(WithMockUhAdmin uhUser) {
        Set<GrantedAuthority> authorities = new LinkedHashSet<>();
        for (String role : uhUser.roles()) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        User user = new User(uhUser.username(), authorities);
        user.setUhuuid(uhUser.uhuuid());

        Map<String, String> attrsMap = new HashMap<>();
        attrsMap.put("cn", uhUser.name());
        UhAttributes attributes = new UhCasAttributes(attrsMap);
        user.setAttributes(attributes);

        final Authentication auth =
                new UsernamePasswordAuthenticationToken(user, "pw", user.getAuthorities());

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(auth);

        return context;
    }

}
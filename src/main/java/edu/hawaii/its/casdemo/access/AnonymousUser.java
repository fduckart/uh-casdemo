package edu.hawaii.its.casdemo.access;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class AnonymousUser extends User {

    public AnonymousUser() {
        super("anonymous", authorities());
    }

    private static Collection<GrantedAuthority> authorities() {
        Set<GrantedAuthority> authorities = new LinkedHashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(Role.ANONYMOUS.longName()));
        return authorities;
    }
}

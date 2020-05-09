package edu.hawaii.its.casdemo.access;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class RoleHolder {

    private Set<GrantedAuthority> authorities = new LinkedHashSet<>();

    // Constructor.
    public RoleHolder() {
        this(null);
    }

    // Constructor.
    public RoleHolder(Set<Role> roles) {
        if (roles != null) {
            for (Role role : roles) {
                add(role);
            }
        }
    }

    public void add(Role role) {
        authorities.add(new SimpleGrantedAuthority(role.longName()));
    }

    public Set<GrantedAuthority> getAuthorites() {
        return authorities;
    }

    public int size() {
        return authorities.size();
    }

    public boolean contains(Role role) {
        return authorities.contains(new SimpleGrantedAuthority(role.longName()));
    }

    @Override
    public String toString() {
        return "RoleHolder [authorities=" + authorities + "]";
    }
}

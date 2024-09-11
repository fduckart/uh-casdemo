package edu.hawaii.its.casdemo.access;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class User extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 5L;
    private final String uhUuid;
    private final UhAttributes attributes;

    // Constructor.
    private User(String username, String uhUuid, Collection<GrantedAuthority> authorities, UhAttributes attributes) {
        super(username, "", authorities);
        this.uhUuid = uhUuid != null ? uhUuid : "";
        this.attributes = attributes != null ? attributes : new UhEmptyAttributes();
    }

    public String getUid() {
        return getUsername();
    }

    public String getUhUuid() {
        return uhUuid;
    }

    // Get any single-value loaded attribute.
    public String getAttribute(String name) {
        return attributes.getValue(name);
    }

    // Get any multivalue-value loaded attribute.    
    public List<String> getAttributes(String name) {
        return attributes.getValues(name);
    }

    // All the attributes.
    public UhAttributes getAttributes() {
        return attributes;
    }

    // Convience attribute method.
    public String getName() {
        return attributes.getValue("displayName");
    }

    public boolean hasRole(Role role) {
        return getAuthorities().contains(new SimpleGrantedAuthority(role.longName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + uhUuid.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return uhUuid.equals(other.uhUuid);
    }

    @Override
    public String toString() {
        return "User [uid=" + getUid()
                + ", uhUuid=" + getUhUuid()
                + ", super-class: " + super.toString() + "]";
    }

    public static class Builder {

        private String username;
        private String uhUuid;
        private Collection<GrantedAuthority> authorities;
        private UhAttributes attributes;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder uhUuid(String uhUuid) {
            this.uhUuid = uhUuid;
            return this;
        }

        public Builder authorities(Collection<GrantedAuthority> authorities) {
            this.authorities = authorities;
            return this;
        }

        public Builder attributes(UhAttributes attributes) {
            this.attributes = attributes;
            return this;
        }

        public User create() {
            Objects.requireNonNull(username, "username cannot be null.");
            Objects.requireNonNull(authorities, "authorities cannot be null.");

            return new User(username, uhUuid, authorities, attributes);
        }
    }
}

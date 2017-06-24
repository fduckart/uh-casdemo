package edu.hawaii.its.casdemo.access;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class User extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 5L;
    private String uhuuid;
    private UhAttributes attributes;

    // Constructor.
    public User(String username, String uhuuid, Collection<GrantedAuthority> authorities) {
        super(username, "", authorities);
        setUhuuid(uhuuid);
    }

    // Constructor.
    public User(String username, Collection<GrantedAuthority> authorities) {
        this(username, null, authorities);
    }

    public String getUid() {
        return getUsername();
    }

    public String getUhuuid() {
        return uhuuid;
    }

    public void setUhuuid(String uhuuid) {
        this.uhuuid = uhuuid != null ? uhuuid : "";
    }

    public String getAttribute(String name) {
        return attributes.getValue(name);
    }

    public UhAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(UhAttributes attributes) {
        this.attributes = attributes;
    }

    public String getName() {
        return attributes.getValue("cn");
    }

    public boolean hasRole(Role role) {
        return getAuthorities().contains(new SimpleGrantedAuthority(role.longName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + uhuuid.hashCode();
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
        if (!uhuuid.equals(other.uhuuid))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [uid=" + getUid()
                + ", uhuuid=" + getUhuuid()
                + ", super-class: " + super.toString() + "]";
    }
}

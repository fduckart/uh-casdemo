package edu.hawaii.its.casdemo.access;

public enum Role {
    ANONYMOUS,
    USER,
    FACULTY,
    STAFF,
    ADMIN;

    public String longName() {
        return "ROLE_" + name();
    }

    @Override
    public String toString() {
        return longName();
    }

    public static Role find(String name) {
        for (Role role : Role.values()) {
            if (role.name().equals(name)) {
                return role; // Found it.
            }
        }
        return null;
    }
}

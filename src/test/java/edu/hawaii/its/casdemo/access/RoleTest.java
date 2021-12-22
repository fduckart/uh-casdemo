package edu.hawaii.its.casdemo.access;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class RoleTest {

    @Test
    public void longName() {
        for (Role role : Role.values()) {
            assertEquals("ROLE_" + role.name(), role.longName());
        }
    }

    @Test
    public void find() {
        Role role = Role.find(Role.ADMIN.name());
        assertNotNull(role);
        assertThat(role.name(), equalTo(Role.ADMIN.name()));
        assertThat(role.longName(), equalTo(Role.ADMIN.longName()));
        assertThat(role.toString(), equalTo("ROLE_ADMIN"));
        role = Role.find("non-existent-role");
        assertNull(role);
    }
}

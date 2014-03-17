package edu.hawaii.its.casdemo.access;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RoleTest {

    @Test
    public void longName() {
        for (Role role : Role.values()) {
            assertEquals("ROLE_" + role.name(), role.longName());
        }
    }
}

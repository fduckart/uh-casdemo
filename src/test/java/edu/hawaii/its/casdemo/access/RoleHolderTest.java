package edu.hawaii.its.casdemo.access;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

public class RoleHolderTest {

    @Test
    public void constructors() {
        RoleHolder roleHolder = new RoleHolder();
        assertThat(roleHolder.size(), equalTo(0));

        Set<Role> roles = null;
        roleHolder = new RoleHolder(roles);
        assertThat(roleHolder.size(), equalTo(0));

        roles = new LinkedHashSet<>();
        roleHolder = new RoleHolder(roles);
        assertThat(roleHolder.size(), equalTo(0));

        roles = new LinkedHashSet<>();
        roles.add(Role.ANONYMOUS);
        roleHolder = new RoleHolder(roles);
        assertThat(roleHolder.size(), equalTo(1));

        roles = new LinkedHashSet<>();
        roles.add(Role.ANONYMOUS);
        roles.add(Role.USER);
        roleHolder = new RoleHolder(roles);
        assertThat(roleHolder.size(), equalTo(2));

        roles = new LinkedHashSet<>();
        roles.add(Role.ANONYMOUS);
        roles.add(Role.USER);
        roles.add(Role.STAFF);
        roleHolder = new RoleHolder(roles);
        assertThat(roleHolder.size(), equalTo(3));
    }

    @Test
    public void basics() {
        RoleHolder roleHolder = new RoleHolder();
        assertThat(roleHolder.size(), equalTo(0));
        roleHolder.add(Role.ANONYMOUS);
        assertThat(roleHolder.size(), equalTo(1));
        roleHolder.add(Role.USER);
        assertThat(roleHolder.size(), equalTo(2));
        roleHolder.add(Role.STAFF);
        assertThat(roleHolder.size(), equalTo(3));

        assertThat(roleHolder.toString(), containsString("ROLE_ANONYMOUS"));
        assertThat(roleHolder.toString(), containsString("ROLE_USER"));
        assertThat(roleHolder.toString(), containsString("ROLE_STAFF"));
    }

    @Test
    public void contains() {
    }
}

package edu.hawaii.its.casdemo.access;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.hawaii.its.casdemo.configuration.SpringBootWebApplication;

@SpringBootTest(classes = { SpringBootWebApplication.class })
public class AuthorizationServiceTest {

    @Autowired
    private AuthorizationService authorizationService;

    @Test
    public void basics() {
        assertNotNull(authorizationService);
    }

    @Test
    public void fetch() {
        RoleHolder roleHolder = authorizationService.fetchRoles("19407388");
        assertThat(roleHolder.size(), equalTo(2));
        assertFalse(roleHolder.contains(Role.ANONYMOUS));
        assertTrue(roleHolder.contains(Role.USER));
        assertTrue(roleHolder.contains(Role.ADMIN));
        assertFalse(roleHolder.contains(Role.STAFF));
        assertFalse(roleHolder.contains(Role.FACULTY));

        roleHolder = authorizationService.fetchRoles("10336801");
        assertThat(roleHolder.size(), equalTo(2));
        assertFalse(roleHolder.contains(Role.ANONYMOUS));
        assertTrue(roleHolder.contains(Role.USER));
        assertFalse(roleHolder.contains(Role.STAFF));
        assertTrue(roleHolder.contains(Role.ADMIN));
        assertFalse(roleHolder.contains(Role.FACULTY));

        roleHolder = authorizationService.fetchRoles("10000004");
        assertThat(roleHolder.size(), equalTo(2));
        assertFalse(roleHolder.contains(Role.ANONYMOUS));
        assertTrue(roleHolder.contains(Role.USER));
        assertTrue(roleHolder.contains(Role.ADMIN));
        assertFalse(roleHolder.contains(Role.STAFF));
        assertFalse(roleHolder.contains(Role.FACULTY));

        roleHolder = authorizationService.fetchRoles("10000005");
        assertThat(roleHolder.size(), equalTo(2));
        assertFalse(roleHolder.contains(Role.ANONYMOUS));
        assertTrue(roleHolder.contains(Role.USER));
        assertTrue(roleHolder.contains(Role.ADMIN));

        roleHolder = authorizationService.fetchRoles("90000009");
        assertThat(roleHolder.size(), equalTo(2));
        assertFalse(roleHolder.contains(Role.ANONYMOUS));
        assertTrue(roleHolder.contains(Role.USER));
        assertTrue(roleHolder.contains(Role.ADMIN));
        assertFalse(roleHolder.contains(Role.STAFF));
        assertFalse(roleHolder.contains(Role.FACULTY));

        roleHolder = authorizationService.fetchRoles("10000006", false);
        assertThat(roleHolder.size(), equalTo(1));
        assertTrue(roleHolder.contains(Role.ANONYMOUS));
        assertFalse(roleHolder.contains(Role.USER));
        assertFalse(roleHolder.contains(Role.ADMIN));
        assertFalse(roleHolder.contains(Role.STAFF));
        assertFalse(roleHolder.contains(Role.FACULTY));

        roleHolder = authorizationService.fetchRoles("11668149");
        assertThat(roleHolder.size(), equalTo(2));
        assertFalse(roleHolder.contains(Role.ANONYMOUS));
        assertTrue(roleHolder.contains(Role.USER));
        assertTrue(roleHolder.contains(Role.ADMIN));
        assertFalse(roleHolder.contains(Role.FACULTY));
        assertFalse(roleHolder.contains(Role.STAFF));
    }
}

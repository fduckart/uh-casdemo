package edu.hawaii.its.casdemo.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.hawaii.its.casdemo.configuration.SpringBootWebApplication;
import edu.hawaii.its.casdemo.type.Role;

@SpringBootTest(classes = { SpringBootWebApplication.class })
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void findAll() {
        assertNotNull(roleService);

        final int id = 1;
        Role r0 = roleService.find(id);
        Role r1 = roleService.find(id);
        assertEquals(r0, r1);
        assertSame(r0, r1);

        assertEquals(r0, r1);
        assertSame(r0, r1);

        Role r2 = roleService.find(id);
        assertEquals(r0, r2);
        assertSame(r0, r2);

        Role r3 = roleService.findByRole("FACULTY");
        assertThat(r3.getRole(), equalTo("FACULTY"));
        assertThat(r3.getShortDescription(), equalTo("Faculty"));
        assertThat(r3.getDescription(), equalTo("Faculty"));

        Role rn = roleService.find(666);
        assertNull(rn);
    }

}

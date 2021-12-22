package edu.hawaii.its.casdemo.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.hawaii.its.casdemo.configuration.SpringBootWebApplication;
import edu.hawaii.its.casdemo.type.Role;

@SpringBootTest(classes = { SpringBootWebApplication.class })
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void findAll() {
        assertNotNull(roleRepository);

        long count = roleRepository.count();
        assertThat(count, equalTo(4L));

        final int id = 1;
        Role r0 = roleRepository.findById(id).get();
        Role r1 = roleRepository.findById(id).get();
        assertEquals(r0, r1);
        assertSame(r0, r1);

        r1.setDescription(r1.getDescription() + " (updated)");
        roleRepository.save(r1);

        assertEquals(r0, r1);
        assertSame(r0, r1);

        Role r2 = roleRepository.findById(id).get();
        assertEquals(r0, r2);
        assertSame(r0, r2);

        Role r3 = roleRepository.findByRole("STAFF");
        assertThat(r3.getRole(), equalTo("STAFF"));

        Optional<Role> rn = roleRepository.findById(666);
        assertThat(rn.isPresent(), equalTo(false));
    }

}

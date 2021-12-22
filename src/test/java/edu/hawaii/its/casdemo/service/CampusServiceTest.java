package edu.hawaii.its.casdemo.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import edu.hawaii.its.casdemo.configuration.SpringBootWebApplication;
import edu.hawaii.its.casdemo.repository.CampusRepository;
import edu.hawaii.its.casdemo.type.Campus;

@SpringBootTest(classes = { SpringBootWebApplication.class })
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class CampusServiceTest {

    @Autowired
    private CampusService campusService;

    @Test
    public void findAll() {
        List<Campus> campuses = campusService.findAll();
        assertFalse(campuses.isEmpty());
        assertThat(campuses.size(), equalTo(11));

        // Make sure caching is configured.
        CampusRepository repo = campusService.getCampusRepository();
        campusService.setCampusRepository(null);
        List<Campus> list = campusService.findAll();
        assertFalse(list.isEmpty());
        assertThat(list.size(), equalTo(11));
        assertSame(campuses, list);
        campusService.setCampusRepository(repo);
    }

    @Test
    public void findActualAll() {
        List<Campus> campuses = campusService.findActualAll();
        assertFalse(campuses.isEmpty());
        assertThat(campuses.size(), equalTo(10));
        int id = 0;
        for (Campus c : campuses) {
            assertThat(c.getActual(), equalTo("Y"));

            // Goofy way to check on sorting.
            assertTrue(c.getId() > (id++));
        }

        // Make sure caching is configured.
        CampusRepository repo = campusService.getCampusRepository();
        campusService.setCampusRepository(null);
        List<Campus> list = campusService.findActualAll();
        assertFalse(list.isEmpty());
        assertThat(list.size(), equalTo(10));
        assertSame(campuses, list);
        campusService.setCampusRepository(repo);
    }

    @Test
    public void find() {
        Campus c0 = campusService.find(7);
        assertThat(c0.getId(), equalTo(7));
        assertThat(c0.getCode(), equalTo("MA"));
        assertThat(c0.getDescription(), equalTo("UH Manoa"));
        assertThat(c0.getActual(), equalTo("Y"));
    }

    @Test
    public void addCampus() {
        final long count0 = campusService.count();
        List<Campus> campuses = campusService.findAll();

        Campus oX = campusService.find(campuses.get(0).getId());
        Campus oY = campuses.get(campuses.size() - 1);

        // Make sure state id doesn't exist first.
        Integer id = oY.getId() + 1;
        Campus campus = campusService.find(id);
        assertNull(campus);

        campus = new Campus();
        campus.setCode("SS");
        campus.setDescription("Sky Saw");
        campus.setActual("N");

        // What we are testing.
        campusService.addCampus(campus);

        // Check that we have a new record.
        long count1 = campusService.count();
        assertThat(count1, equalTo(count0 + 1));

        // Check the new record.
        Campus oZ = campusService.find(id);
        assertThat(oZ, equalTo(campus));

        // Ensure we didn't upset the caching.
        Campus c0 = campusService.find(id);
        assertSame(oZ, campus);
        assertSame(oZ, c0);
        Campus cX = campusService.find(oX.getId());
        assertThat(cX, equalTo(oX));
        assertSame(oX, cX);
    }

    @Test
    public void campusCache() {
        Campus c0 = campusService.find(1);
        Campus c1 = campusService.find(1);
        assertSame(c0, c1);

        CampusRepository repo = campusService.getCampusRepository();
        campusService.setCampusRepository(null);
        Campus c2 = campusService.find(1);
        Campus c3 = campusService.find(1);
        assertSame(c2, c3);
        campusService.setCampusRepository(repo);
    }

}

package edu.hawaii.its.casdemo.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.hawaii.its.casdemo.configuration.CachingConfig;
import edu.hawaii.its.casdemo.configuration.DatabaseConfig;
import edu.hawaii.its.casdemo.configuration.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { DatabaseConfig.class, WebConfig.class, CachingConfig.class })
public class AdministratorServiceSystemTest {

    @Autowired
    private AdministratorService administratorService;

    @Test
    public void exists() {
        assertTrue(administratorService.exists("89999999"));
        assertTrue(administratorService.exists("10000001"));

        assertFalse(administratorService.exists("10000008"));
        assertFalse(administratorService.exists(null));
        assertFalse(administratorService.exists(""));
        assertFalse(administratorService.exists("  "));
        assertFalse(administratorService.exists("no-way-none"));
    }

    @Test
    public void testBrokenConfig() {
        AdministratorService administratorService = new AdministratorServiceImpl();

        assertFalse(administratorService.exists("10000001"));
        assertFalse(administratorService.exists("10000002"));

        assertFalse(administratorService.exists(null));
        assertFalse(administratorService.exists(""));
        assertFalse(administratorService.exists("  "));
        assertFalse(administratorService.exists("no-way-none"));
    }
}

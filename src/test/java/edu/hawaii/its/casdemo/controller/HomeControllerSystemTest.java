package edu.hawaii.its.casdemo.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.hawaii.its.casdemo.configuration.CachingConfig;
import edu.hawaii.its.casdemo.configuration.DatabaseConfig;
import edu.hawaii.its.casdemo.configuration.WebConfig;
import edu.hawaii.its.casdemo.security.UserContextServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { DatabaseConfig.class, WebConfig.class, CachingConfig.class })
public class HomeControllerSystemTest {

    @Autowired
    private HomeController homeController;

    @Before
    public void setUp() {
        homeController.setUserContextService(new UserContextServiceImpl() {
            public String getCurrentUsername() {
                return "duckart";
            }

            public Long getCurrentUhuuid() {
                return new Long(89999999L);
            }
        });
    }

    @Test
    public void testConstruction() {
        assertNotNull(homeController);
    }

}

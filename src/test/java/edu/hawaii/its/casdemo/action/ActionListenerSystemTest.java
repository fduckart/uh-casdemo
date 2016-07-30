package edu.hawaii.its.casdemo.action;

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
public class ActionListenerSystemTest {

    @Autowired
    private ActionListener actionListener;

    @Test
    public void mapNotEmpty() {
        assertTrue(actionListener.mapSize() > 0);
    }
}

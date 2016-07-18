package edu.hawaii.its.casdemo.action;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath:META-INF/spring/root-context.xml" })
public class ActionListenerSystemTest {

    @Autowired
    private ActionListener actionListener;

    @Test
    public void mapNotEmpty() {
        assertTrue(actionListener.mapSize() > 0);
    }
}

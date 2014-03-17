package edu.hawaii.its.casdemo.action;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ActionListenerSystemTest {

    @Autowired
    private ActionListener actionListener;

    @Test
    public void mapNotEmpty() {
        assertTrue(actionListener.mapSize() > 0);
    }
}

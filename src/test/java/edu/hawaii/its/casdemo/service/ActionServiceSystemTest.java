package edu.hawaii.its.casdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import edu.hawaii.its.casdemo.configuration.CachingConfig;
import edu.hawaii.its.casdemo.configuration.DatabaseConfig;
import edu.hawaii.its.casdemo.configuration.WebConfig;
import edu.hawaii.its.casdemo.type.ActionLog;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { DatabaseConfig.class, WebConfig.class, CachingConfig.class })
public class ActionServiceSystemTest {

    @Autowired
    private ActionService actionService;

    @Test
    public void construction() {
        assertNotNull(actionService);
    }

    @Test
    @Transactional
    public void record() {
        long count = actionService.logCount();
        assertEquals(0, count);

        final long RUNS = 10;
        for (int i = 0; i < RUNS; i++) {
            ActionLog actionLog = new ActionLog();
            actionLog.setActionId(Long.valueOf(10 + (i % 3)));
            actionLog.setUserUhuuid(Long.valueOf(89999999));
            actionLog.setViewUhuuid(Long.valueOf(89999999));

            actionService.record(actionLog);
        }

        assertEquals(count + RUNS, actionService.logCount());
    }

}

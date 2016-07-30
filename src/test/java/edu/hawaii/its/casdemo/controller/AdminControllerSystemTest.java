package edu.hawaii.its.casdemo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import edu.hawaii.its.casdemo.configuration.CachingConfig;
import edu.hawaii.its.casdemo.configuration.DatabaseConfig;
import edu.hawaii.its.casdemo.configuration.WebConfig;
import edu.hawaii.its.casdemo.type.Action;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { DatabaseConfig.class, WebConfig.class, CachingConfig.class })
public class AdminControllerSystemTest {

    @Autowired
    private AdminController controller;

    @Test
    public void actions() {
        Model model = new ExtendedModelMap();
        assertEquals("actions/list", controller.listActions(model));
        Map<String, Object> map = model.asMap();
        assertFalse(map.entrySet().isEmpty());

        @SuppressWarnings("unchecked")
        List<Action> actions = (List<Action>) map.get("actionList");

        Action a0 = actions.get(0);
        assertEquals(10, a0.getId().intValue());
        assertEquals("employee.view.home", a0.getCode());
        a0 = null;

        Action aZ = actions.get(3);
        assertEquals(13, aZ.getId().intValue());
        assertEquals("employee.save.casdemo", aZ.getCode());
        aZ = null;
    }
}

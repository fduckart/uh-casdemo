package edu.hawaii.its.casdemo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Locale;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class GateControllerSystemTest {

    @Autowired
    private GateController gateController;

    @Test
    public void testController() {
        Model model = new ExtendedModelMap();

        assertEquals("gate", gateController.gate(Locale.US, model));

        assertFalse(model.asMap().entrySet().isEmpty());
        assertTrue(model.asMap().keySet().contains("systemMessage"));
    }
}

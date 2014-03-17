package edu.hawaii.its.casdemo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import edu.hawaii.its.casdemo.type.Action;
import edu.hawaii.its.casdemo.type.Message;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@DirtiesContext
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

    @Ignore
    @Test
    public void messageUpdate() {
        Message message = controller.getMessageService().findMessage(1);
        final String text = message.getText();
        message.setText("XxX" + message.getText());
        Model model = new ExtendedModelMap();
        Map<Object, Object> map = new HashMap<Object, Object>();
        BindingResult result = new MapBindingResult(map, "nothing");

        controller.messageUpdate(message, model, result);

        Message messageAfter = controller.getMessageService().findMessage(1);
        assertEquals(messageAfter.getText(), message.getText());

        message.setText(text);
        controller.messageUpdate(message, model, result);
        messageAfter = controller.getMessageService().findMessage(1);
        assertEquals(text, messageAfter.getText());
    }
}

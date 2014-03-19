package edu.hawaii.its.casdemo.controller;

import edu.hawaii.its.casdemo.service.MessageService;
import edu.hawaii.its.casdemo.type.Message;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GateController {

    private static final Logger logger = LoggerFactory.getLogger(GateController.class);

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = { "/", "/gate" }, method = { RequestMethod.GET})    
    public String gate(Locale locale, Model model) {
        logger.debug("User at gate. The client locale is {}.", locale);

        try {
            Message message = messageService.findMessage(Message.GATE_MESSAGE);
            if (message != null) {
                model.addAttribute("systemMessage", message.getText());
            }
        } catch (Exception e) {
            logger.error("Error", e);
        }

        return "gate";
    }

    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String denied() {
        return "denied";
    }

}

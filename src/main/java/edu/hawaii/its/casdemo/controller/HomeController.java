package edu.hawaii.its.casdemo.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.hawaii.its.casdemo.access.User;
import edu.hawaii.its.casdemo.action.ActionRecorder;
import edu.hawaii.its.casdemo.security.UserContextService;
import edu.hawaii.its.casdemo.service.MessageService;
import edu.hawaii.its.casdemo.type.Message;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ActionRecorder actionRecorder;

    @Autowired
    private UserContextService userContextService;

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = { "", "/", "/gate" }, method = { RequestMethod.GET })
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

    @PreAuthorize("hasRole('ROLE_UH')")
    @RequestMapping(value = { "/attributes" }, method = { RequestMethod.GET })
    public String attributes(Locale locale, Model model) {

        logger.info("Entered attributes...");

        User user = userContextService.getCurrentUser();
        logger.info("current user    : " + user);
        actionRecorder.publish("employee.view.home", user.getUhuuid());
        model.addAttribute("currentUser", user);

        logger.info("Leaving attributes.");

        return "attributes";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Locale locale, Model model) {
        return "admin";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Locale locale, Model model) {
        return "contact";
    }

    @RequestMapping(value = "/faq", method = RequestMethod.GET)
    public String faq(Locale locale, Model model) {
        return "faq";
    }

    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String denied() {
        return "denied";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String invalid() {
        return "redirect:/";
    }

    public void setUserContextService(UserContextService userContextService) {
        this.userContextService = userContextService;
    }

    public void setActionRecorder(ActionRecorder actionRecorder) {
        this.actionRecorder = actionRecorder;
    }
}

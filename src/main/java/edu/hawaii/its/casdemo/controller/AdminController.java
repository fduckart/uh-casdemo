package edu.hawaii.its.casdemo.controller;

import edu.hawaii.its.casdemo.form.AdminMessageForm;
import edu.hawaii.its.casdemo.security.UserContextService;
import edu.hawaii.its.casdemo.service.ActionService;
import edu.hawaii.its.casdemo.service.MessageService;
import edu.hawaii.its.casdemo.type.Message;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

@Controller
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private ActionService actionService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserContextService userContextService;

    @RequestMapping(value = "/admin/message", method = RequestMethod.GET)
    public String message(Model model) {
        Long uhuuid = userContextService.getCurrentUhuuid();
        logger.info("message;  uhuuid: " + uhuuid);
        Message message = messageService.findMessage(1);
        logger.info("message; message: " + message);

        model.addAttribute("messageAttribute", message);

        return "admin/message";
    }

    @RequestMapping(value = "/admin/message", method = RequestMethod.POST)
    public String messageUpdate(@ModelAttribute("messageAttribute") Message message,
            Model model, BindingResult result) {
        logger.info("messageUpdate; message: " + message);
        logger.info("messageUpdate; hasErrors? " + result.hasErrors());
        if (result.hasErrors()) {
            return "admin/message";
        }

        messageService.update(message);
        model.addAttribute("messageAttribute", message);

        return "redirect:/gate";
    }

    @RequestMapping(value = "/admin/actions", method = RequestMethod.GET)
    public String listActions(Model model) {
        model.addAttribute(actionService.findActions());
        return "actions/list"; // Return view name.
    }

    @ModelAttribute("adminMessageForm")
    public AdminMessageForm createAdminMessageForm() {
        AdminMessageForm form = new AdminMessageForm();
        Message message = messageService.findMessage(1);
        if (message != null) {
            form.setMessage(message.getText());
        }
        return form;
    }

    public void setUserContextService(UserContextService userContextService) {
        this.userContextService = userContextService;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Exceptions for testing. Remove this stuff at some point.
    //
    
    private boolean isExceptionTestingEnabled() {
        return true;
    }

    @RequestMapping(value = "/admin/ioexception", method = RequestMethod.GET)
    public String ioexception(Model model) throws IOException {
        if (isExceptionTestingEnabled()) {
            throw new IOException("Threw an IOException from admin!");
        }
        return "exception"; // Return view name.
    }

    @RequestMapping(value = "/admin/npe", method = RequestMethod.GET)
    public String npe(Model model) throws NullPointerException {
        if (isExceptionTestingEnabled()) {
            throw new NullPointerException("Threw an NullPointerException from admin!");
        }
        return "exception"; // Return view name.
    }

    @RequestMapping(value = "/admin/404", method = RequestMethod.GET)
    public String pageNotFound(Model modelthrowable) throws Throwable {
        if (isExceptionTestingEnabled()) {
            throw new NoSuchRequestHandlingMethodException("pageNotFound", getClass());
        }
        return "pageNotFound"; // Return view name.
    }

}

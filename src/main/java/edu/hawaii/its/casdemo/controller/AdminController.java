package edu.hawaii.its.casdemo.controller;

import edu.hawaii.its.casdemo.service.ActionService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

@Controller
public class AdminController {

    @Autowired
    private ActionService actionService;

    @RequestMapping(value = "/admin/actions", method = RequestMethod.GET)
    public String listActions(Model model) {
        model.addAttribute(actionService.findActions());
        return "actions/list"; // Return view name.
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

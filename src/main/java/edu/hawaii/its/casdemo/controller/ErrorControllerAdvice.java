package edu.hawaii.its.casdemo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.hawaii.its.casdemo.access.UserContextService;
import edu.hawaii.its.casdemo.type.Feedback;

@ControllerAdvice
public class ErrorControllerAdvice {

    private static final Log logger = LogFactory.getLog(ErrorControllerAdvice.class);

    @Autowired
    private UserContextService userContextService;

    private String handler(Throwable e, RedirectAttributes redirectAttributes) {
        String username = userContextService.getCurrentUsername();
        logger.error("username: " + username + "; Error: " + e);
        redirectAttributes.addFlashAttribute("feedback", new Feedback(e));
        return "redirect:/feedback";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, RedirectAttributes redirectAttributes) {
        logger.error("handleException called");
        return handler(e, redirectAttributes);
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(RuntimeException e, RedirectAttributes redirectAttributes) {
        logger.error("handleRuntimeException called");
        return handler(e, redirectAttributes);
    }

}

package edu.hawaii.its.casdemo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.hawaii.its.casdemo.access.UserContextService;

@ControllerAdvice
public class ErrorControllerAdvice {

    private static final Log logger = LogFactory.getLog(ErrorControllerAdvice.class);

    @Autowired
    private UserContextService userContextService;

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        String username = userContextService.getCurrentUsername();
        logger.error("username: " + username + "; Exception: " + e, e);

        return "redirect:/";
    }

}
package edu.hawaii.its.casdemo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorRestController {

    private static final Log logger = LogFactory.getLog(ErrorRestController.class);

    @PostMapping("/api/error/{data}")
    public ResponseEntity<Object> error(@PathVariable String data) {
        logger.warn("error; data: " + data);
        return new ResponseEntity<>(new Exception(data), HttpStatus.OK);
    }
}

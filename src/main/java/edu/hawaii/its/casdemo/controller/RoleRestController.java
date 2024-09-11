package edu.hawaii.its.casdemo.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.hawaii.its.casdemo.service.RoleService;
import edu.hawaii.its.casdemo.model.Role;

@RestController
public class RoleRestController {

    private static final Log logger = LogFactory.getLog(RoleRestController.class);

    @Autowired
    private RoleService roleService;

    @GetMapping("/api/roles")
    public ResponseEntity<List<Role>> roles() {
        logger.info("Entered REST roles...");
        List<Role> data = roleService.findAll();
        return ResponseEntity
                .ok()
                .body(data);
    }

}

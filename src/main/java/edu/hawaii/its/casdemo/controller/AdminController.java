package edu.hawaii.its.casdemo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private static final Log logger = LogFactory.getLog(AdminController.class);

    @GetMapping("/admin")
    public String admin() {
        logger.debug("User at admin.");

        return "admin/admin";
    }

    @GetMapping(value = { "/admin/application/role", "/admin/application/roles" })
    public String adminUserRole() {
        logger.debug("User at admin/application/role.");

        return "admin/application-role";
    }

}
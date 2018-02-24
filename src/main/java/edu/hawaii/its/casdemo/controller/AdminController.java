package edu.hawaii.its.casdemo.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private static final Log logger = LogFactory.getLog(AdminController.class);

    @GetMapping(value = { "", "/" })
    public String admin() {
        logger.debug("User at admin.");
        return "admin/admin";
    }

    @GetMapping(value = { "/application/role", "/application/roles" })
    public String adminUserRole() {
        logger.debug("User at admin/application/role.");
        return "admin/application-role";
    }

    @GetMapping("/exc")
    public void exc() throws Exception {
        throw new Exception("basic exception");
    }

    @GetMapping("/fnf")
    public void fnf() throws FileNotFoundException {
        throw new FileNotFoundException("file not found");
    }

    @GetMapping("/ioe")
    public void ioe() throws IOException {
        throw new IOException("I/O exception!");
    }

    @GetMapping("/rte")
    public void rte() throws RuntimeException {
        throw new RuntimeException("basic runtime exception");
    }

    @GetMapping("/thw")
    public void thw() throws Throwable {
        throw new Throwable("basic throwable");
    }

}
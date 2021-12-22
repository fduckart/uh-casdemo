package edu.hawaii.its.casdemo.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import edu.hawaii.its.casdemo.configuration.SpringBootWebApplication;

@SpringBootTest(classes = { SpringBootWebApplication.class })
public class AdminControllerTest {

    @Value("${cas.login.url}")
    private String casLoginUrl;

    @Autowired
    private AdminController adminController;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void construction() {
        assertNotNull(adminController);
    }

    @Test
    @WithMockUhUser(username = "admin", roles = { "ROLE_USER", "ROLE_ADMIN" })
    public void admin() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/admin"));
    }

    @Test
    @WithAnonymousUser
    public void adminViaAnonymous() throws Exception {
        // Anonymous users not allowed into admin area.
        mockMvc.perform(get("/admin"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern(casLoginUrl + "**"));
    }

    @Test
    @WithMockUhUser
    public void adminViaUh() throws Exception {
        // Access forbidden due to insufficient role.
        mockMvc.perform(get("/admin"))
                .andExpect(status().is4xxClientError())
                .andExpect(status().is(403));
    }

    @Test
    @WithAnonymousUser
    public void excViaAnonymous() throws Exception {
        // Anonymous users not allowed into admin area.
        mockMvc.perform(get("/admin/exc"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern(casLoginUrl + "**"));
    }

    @Test
    @WithMockUhUser
    public void excViaUh() throws Exception {
        // Access forbidden due to insufficient role.
        mockMvc.perform(get("/admin/exc"))
                .andExpect(status().is4xxClientError())
                .andExpect(status().is(403));
    }

    @Test
    @WithMockUhAdmin
    public void excViaAdmin() throws Exception {
        mockMvc.perform(get("/admin/exc"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/feedback"));
    }

    @Test
    @WithMockUhAdmin
    public void fnfViaAdmin() throws Exception {
        mockMvc.perform(get("/admin/fnf"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/feedback"));
    }

    @Test
    @WithMockUhAdmin
    public void ioeViaAdmin() throws Exception {
        mockMvc.perform(get("/admin/ioe"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/feedback"));
    }

    @Test
    @WithMockUhAdmin
    public void rteViaAdmin() throws Exception {
        mockMvc.perform(get("/admin/rte"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/feedback"));
    }

    @Test
    @WithMockUhAdmin
    public void thwViaAdmin() throws Exception {
        mockMvc.perform(get("/admin/thw"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/feedback"));
    }

    @Test
    @WithMockUhAdmin
    public void adminUserRole() throws Exception {
        mockMvc.perform(get("/admin/application/role"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/application-role"));
    }

}

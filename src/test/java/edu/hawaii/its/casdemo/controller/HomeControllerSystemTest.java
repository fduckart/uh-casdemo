package edu.hawaii.its.casdemo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import edu.hawaii.its.casdemo.configuration.CachingConfig;
import edu.hawaii.its.casdemo.configuration.DatabaseConfig;
import edu.hawaii.its.casdemo.configuration.SecurityConfig;
import edu.hawaii.its.casdemo.configuration.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        SecurityConfig.class,
        DatabaseConfig.class,
        WebConfig.class,
        CachingConfig.class })
public class HomeControllerSystemTest {

    @Value("${cas.login.url}")
    private String casLoginUrl;

    @Autowired
    private HomeController homeController;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void testConstruction() {
        assertNotNull(homeController);
    }

    @Test
    public void testController() {
        Model model = new ExtendedModelMap();

        assertEquals("gate", homeController.gate(Locale.US, model));

        assertFalse(model.asMap().entrySet().isEmpty());
        assertTrue(model.asMap().keySet().contains("systemMessage"));
    }

    @Test
    public void requestUrlDenied() throws Exception {
        mockMvc.perform(get("/denied"))
                .andExpect(status().isOk())
                .andExpect(view().name("denied"));
    }

    @Test
    public void requestUrl404() throws Exception {
        mockMvc.perform(get("/404"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
    }

    @Test
    @WithAnonymousUser
    public void attributesViaAnonymous() throws Exception {
        // Anonymous users not allowed here.
        mockMvc.perform(get("/attributes"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUhUser(username = "uh", roles = { "ROLE_UH" })
    public void requestUrlAttributes() throws Exception {
        mockMvc.perform(get("/attributes"))
                .andExpect(status().isOk())
                .andExpect(view().name("attributes"));
    }

    @Test
    @WithMockUhUser(username = "admin", roles = { "ROLE_UH", "ROLE_ADMIN" })
    public void attributesViaAdmin() throws Exception {
        // Should be high enough role for access.
        mockMvc.perform(get("/attributes"))
                .andExpect(status().isOk())
                .andExpect(view().name("attributes"));
    }

}

package edu.hawaii.its.casdemo.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import edu.hawaii.its.casdemo.configuration.SpringBootWebApplication;

@SpringBootTest(classes = { SpringBootWebApplication.class })
public class CampusRestControllerTest {

    final MediaType APPLICATION_JSON_UTF8 =
            new MediaType(MediaType.APPLICATION_JSON.getType(),
                    MediaType.APPLICATION_JSON.getSubtype(),
                    Charset.forName("utf8"));

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
    @WithAnonymousUser
    public void adminViaAnonymous() throws Exception {
        // Anonymous users not allowed.
        mockMvc.perform(get("/api/campuses"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUhUser
    public void httpGetCampuses() throws Exception {
        mockMvc.perform(get("/api/campuses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(11)))
                .andExpect(jsonPath("$[0].code").value("HA"))
                .andExpect(jsonPath("$[1].code").value("HI"))
                .andExpect(jsonPath("$[2].code").value("HO"))
                .andExpect(jsonPath("$[3].code").value("KA"));
    }
}

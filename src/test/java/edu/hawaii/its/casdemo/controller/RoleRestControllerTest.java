package edu.hawaii.its.casdemo.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import edu.hawaii.its.casdemo.configuration.SpringBootWebApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class RoleRestControllerTest {

    final MediaType APPLICATION_JSON_UTF8 =
            new MediaType(MediaType.APPLICATION_JSON.getType(),
                    MediaType.APPLICATION_JSON.getSubtype(),
                    Charset.forName("utf8"));

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(context).build();
    }

    @Test
    public void httpGetOffices() throws Exception {
        mockMvc.perform(get("/api/roles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].role").value("USER"))
                .andExpect(jsonPath("$[0].shortDescription").value("User"))
                .andExpect(jsonPath("$[0].description").value("User"))

                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].role").value("FACULTY"))
                .andExpect(jsonPath("$[1].shortDescription").value("Faculty"))
                .andExpect(jsonPath("$[1].description").value("Faculty"))

                .andExpect(jsonPath("$[2].id").value("3"))
                .andExpect(jsonPath("$[2].role").value("STAFF"))
                .andExpect(jsonPath("$[2].shortDescription").value("Staff"))
                .andExpect(jsonPath("$[2].description").value("Staff"))

                .andExpect(jsonPath("$[3].id").value("99"))
                .andExpect(jsonPath("$[3].role").value("ADMIN"))
                .andExpect(jsonPath("$[3].shortDescription").value("Administrator"))
                .andExpect(jsonPath("$[3].description").value("Administrator"));
    }

}

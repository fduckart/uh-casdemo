package edu.hawaii.its.casdemo.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import edu.hawaii.its.casdemo.configuration.SpringBootWebApplication;

@SpringBootTest(classes = { SpringBootWebApplication.class })
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ErrorRestControllerTest {

    final MediaType APPLICATION_JSON_UTF8 =
            new MediaType(MediaType.APPLICATION_JSON.getType(),
                    MediaType.APPLICATION_JSON.getSubtype());

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = webAppContextSetup(context).build();
    }

    @Test
    @WithMockUhAdmin
    public void httpGetError() throws Exception {
        mockMvc.perform(post("/api/error/trump-omg"))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        MvcResult mvcResult = mockMvc.perform(post("/api/error/russian-trolls"))
                .andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse mockResponse = mvcResult.getResponse();
        assertThat(mockResponse.getRedirectedUrl(), equalTo(null));
        assertThat(mockResponse.getContentType(),
                equalTo(APPLICATION_JSON_UTF8.toString()));
        assertThat(mockResponse.getContentAsString(),
                containsString("\"message\":\"russian-trolls\""));
        assertThat(mockResponse.getContentAsString(),
                containsString("\"localizedMessage\":\"russian-trolls\""));
    }

}

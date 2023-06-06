package edu.hawaii.its.casdemo.controller;

import edu.hawaii.its.casdemo.configuration.SpringBootWebApplication;
import edu.hawaii.its.casdemo.service.HolidayService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest(classes = {SpringBootWebApplication.class})
@TestMethodOrder(MethodOrderer.Random.class)
public class HolidayRestControllerTest {

    final MediaType APPLICATION_JSON_UTF8 =
            new MediaType(MediaType.APPLICATION_JSON.getType(),
                    MediaType.APPLICATION_JSON.getSubtype());

    @Autowired
    private HolidayRestController restController;

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
    public void testConstruction() {
        assertNotNull(restController);
    }

    @Test
    @WithMockUhUser
    public void httpGetHolidays() throws Exception {
        mockMvc.perform(get("/api/holidays"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("data", hasSize(311)));
    }

    @Test
    @WithMockUhUser
    public void httpGetHolidaysById() throws Exception {
        mockMvc.perform(get("/api/holidays/1096"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("data.description").value("New Year's Day"))
                .andExpect(jsonPath("data.observedDate").value("January 01, 2013, Tuesday"))
                .andExpect(jsonPath("data.officialDate").value("January 01, 2013, Tuesday"))
                .andExpect(jsonPath("data.year").value("2013"))
                .andExpect(jsonPath("data.holidayTypes", hasSize(2)))
                .andExpect(jsonPath("data.holidayTypes[0].description").value("Federal"))
                .andExpect(jsonPath("data.holidayTypes[1].description").value("UH"));
    }

    @Test
    @WithMockUhUser
    public void httpGetHolidaysWithWrongIdType() throws Exception {
        mockMvc.perform(get("/api/holidays/xxx"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/feedback"));
    }

    @Test
    @WithMockUhUser
    public void httpGetHolidaysGrid() throws Exception {
        mockMvc.perform(get("/api/holidaygrid/get?page=1&size=10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("content", hasSize(10)))
                .andExpect(jsonPath("last").value("false"))
                .andExpect(jsonPath("totalPages").value(32))
                .andExpect(jsonPath("totalElements").value(311))
                .andExpect(jsonPath("size").value("10"))
                .andExpect(jsonPath("number").value("1"))
                .andExpect(jsonPath("first").value("false"))
                .andExpect(jsonPath("numberOfElements").value("10"))
                .andExpect(jsonPath("content[9].description").value("Memorial Day"));
    }

    @Test
    @WithMockUhUser
    public void httpGetTypes() throws Exception {
        mockMvc.perform(get("/api/types"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("data", hasSize(3)))
                .andExpect(jsonPath("data[0].description").value("Federal"))
                .andExpect(jsonPath("data[1].description").value("UH"))
                .andExpect(jsonPath("data[2].description").value("State"));
    }

    @Test
    public void accessors() {
        HolidayService holidayService = restController.getHolidayService();
        assertNotNull(holidayService);

        restController.setHolidayService(null);
        assertNull(restController.getHolidayService());

        restController.setHolidayService(holidayService);
        assertNotNull(restController.getHolidayService());
    }

}

package edu.hawaii.its.casdemo.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.hawaii.its.casdemo.configuration.SpringBootWebApplication;
import edu.hawaii.its.casdemo.service.HolidayService;
import edu.hawaii.its.casdemo.util.Strings;

@SpringBootTest(classes = { SpringBootWebApplication.class })
@TestMethodOrder(MethodOrderer.Random.class)
public class HolidayRestControllerTest {

    private static final Log logger = LogFactory.getLog(HolidayRestControllerTest.class);

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
        MvcResult result = mockMvc.perform(get("/api/holidays"))
                .andExpect(status().isOk())
                .andReturn();

        // Start Temporary junk, to test github Actions.
        MockHttpServletResponse response = result.getResponse();
        String responseContent = response.getContentAsString();

        Map<String, Object> map = toMap(responseContent);
        assertThat(map.size(), equalTo(1));

        Object obj = map.get("data");
        @SuppressWarnings({ "unchecked", "rawtypes" })
        List<Object> list = (List) obj;

        int i = 0;
        for (Object h : list) {
            String m = Strings.padLeft(String.valueOf(i++), 4);
            logger.info(m + " ###-### " + h);
        }
        // End hack.
    }

    @Test
    @WithMockUhUser
    public void httpGetHolidaysById() throws Exception {
        mockMvc.perform(get("/api/holidays/1"))
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
                .andExpect(jsonPath("totalPages").value(25))
                .andExpect(jsonPath("totalElements", greaterThanOrEqualTo(248)))
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

    private Map<String, Object> toMap(final String json) throws Exception {
        Map<String, Object> map = new ObjectMapper()
                .readValue(json,
                        new TypeReference<Map<String, Object>>() {
                        });
        return map;
    }

}

package edu.hawaii.its.casdemo.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import edu.hawaii.its.casdemo.configuration.SpringBootWebApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
public class HomeControllerTest {

    @Value("${url.home}")
    private String homeUrl;

    @Value("${cas.login.url}")
    private String casLoginUrl;

    @Value("${cas.logout.url}")
    private String casLoginOut;

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
    public void requestHome() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }

    @Test
    public void requestCampus() throws Exception {
        mockMvc.perform(get("/campus"))
                .andExpect(status().isOk())
                .andExpect(view().name("campus"));

        mockMvc.perform(get("/campuses"))
                .andExpect(status().isOk())
                .andExpect(view().name("campus"));
    }

    @Test
    public void requestContact() throws Exception {
        mockMvc.perform(get("/help/contact"))
                .andExpect(status().isOk())
                .andExpect(view().name("help/contact"));
    }

    @Test
    public void requestFaq() throws Exception {
        mockMvc.perform(get("/help/faq"))
                .andExpect(status().isOk())
                .andExpect(view().name("help/faq"));
    }

    @Test
    @WithMockUhUser
    public void holidayViaUh() throws Exception {
        mockMvc.perform(get("/holiday"))
                .andExpect(status().isOk())
                .andExpect(view().name("holiday"));
    }

    @Test
    @WithAnonymousUser
    public void loginViaAnonymous() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern(casLoginUrl + "**"));
    }

    @Test
    @WithMockUhUser
    public void loginViaUh() throws Exception {
        // Logged in already, URL redirects back to home page.
        mockMvc.perform(get("/login"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/user"));
    }

    @Test
    @WithMockUhUser
    public void logoutViaUh() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/logout").with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andReturn();
        assertThat(mvcResult.getResponse().getRedirectedUrl(), equalTo(homeUrl));
    }

    @Test
    @WithAnonymousUser
    public void userViaAnonymous() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern(casLoginUrl + "**"));
    }

    @Test
    @WithMockUhUser
    public void userViaUh() throws Exception {
        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/user"));
    }

    @Test
    public void fonts() throws Exception {
        mockMvc.perform(get("/help/fonts"))
                .andExpect(status().isOk())
                .andExpect(view().name("help/fonts"));
    }

    @Test
    public void requestUrl404() throws Exception {
        mockMvc.perform(get("/404"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));
    }

    @Test
    public void requestNonExistentUrl() throws Exception {
        mockMvc.perform(get("/not-a-url"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithAnonymousUser
    public void adminUser() throws Exception {
        // Anonymous users not allowed into admin area.
        mockMvc.perform(get("/user"))
                .andExpect(status().is3xxRedirection());
    }

}

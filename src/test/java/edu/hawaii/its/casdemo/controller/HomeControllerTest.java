package edu.hawaii.its.casdemo.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import edu.hawaii.its.casdemo.access.User;
import edu.hawaii.its.casdemo.configuration.SpringBootWebApplication;
import edu.hawaii.its.casdemo.service.EmailService;
import edu.hawaii.its.casdemo.type.Feedback;

@SpringBootTest(classes = { SpringBootWebApplication.class })
public class HomeControllerTest {

    private static boolean sendRan = false;

    @Value("${app.url.home}")
    private String appUrlHome;

    @Value("${cas.login.url}")
    private String casLoginUrl;

    @Autowired
    private HomeController homeController;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        sendRan = false;

        // Make sure the email service does not send emails.
        homeController.getEmailService().setEnabled(false);
        assertFalse(homeController.getEmailService().isEnabled());

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
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern(casLoginUrl + "**"));

        mockMvc.perform(get("/campuses"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern(casLoginUrl + "**"));
    }

    @Test
    @WithAnonymousUser
    public void requestCampusViaAnonymous() throws Exception {
        mockMvc.perform(get("/campus"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern(casLoginUrl + "**"));

        mockMvc.perform(get("/campuses"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern(casLoginUrl + "**"));
    }

    @Test
    @WithMockUhUser
    public void requestCampusViaUser() throws Exception {
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
    @WithMockUhAdmin
    public void holidayViaUhUser() throws Exception {
        mockMvc.perform(get("/holiday"))
                .andExpect(status().isOk())
                .andExpect(view().name("holiday"));
    }

    @Test
    @WithMockUhAdmin
    public void holidayGridViaUhUser() throws Exception {
        mockMvc.perform(get("/holidaygrid"))
                .andExpect(status().isOk())
                .andExpect(view().name("holiday-grid"));
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
    public void loginViaUhUser() throws Exception {
        // Logged in already, URL redirects back to home page.
        mockMvc.perform(get("/login"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/user"));
    }

    @Test
    @WithMockUhUser
    public void logoutViaUhUser() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/logout").with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andReturn();
        assertThat(mvcResult.getResponse().getRedirectedUrl(), equalTo(appUrlHome));
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
    public void userViaUhUser() throws Exception {
        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(view().name("user/user"));
    }

    @Test
    @WithAnonymousUser
    public void userData() throws Exception {
        // Anonymous users not allowed here.
        mockMvc.perform(post("/user/data").with(csrf()))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUhUser(username = "beno")
    public void userDataViaUhUser() throws Exception {

        assertFalse(sendRan);

        homeController.setEmailService(new EmailService(null) {
            @Override
            public void sendCasData(User user) {
                assertThat(user.getUid(), equalTo("beno"));
                sendRan = true;
            }
        });

        mockMvc.perform(post("/user/data").with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/user"));

        assertTrue(sendRan);
    }

    @Test
    @WithAnonymousUser
    public void feedbackViaAnonymous() throws Exception {
        // Anonymous users not allowed here.
        mockMvc.perform(post("/feedback").with(csrf()))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUhUser(username = "krichards")
    public void feedbackGetViaUhUser() throws Exception {

        // Be sure not to send email.
        assertFalse(homeController.getEmailService().isEnabled());

        // What we are testing.
        mockMvc.perform(get("/feedback").with(csrf()))
                .andExpect(status().isOk())
                .andExpect(view().name("feedback/form"));
    }

    @Test
    @WithAnonymousUser
    public void feedbackErrorViaAnonymous() throws Exception {
        // Anonymous users not allowed here.
        mockMvc.perform(post("/feedback/politics").with(csrf()))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUhUser(username = "krichards")
    public void feedbackErrorGetViaUhUser() throws Exception {

        // Be sure not to send email.
        assertFalse(homeController.getEmailService().isEnabled());

        // What we are testing.
        mockMvc.perform(get("/feedback/icarus").with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/feedback"));
    }

    @Test
    @WithMockUhUser(username = "krichards")
    public void feedbackPostViaUhUser() throws Exception {

        assertFalse(sendRan);

        homeController.setEmailService(new EmailService(null) {
            @Override
            public void sendFeedbackData(User user, Feedback feedback) {
                assertThat(user.getUid(), equalTo("krichards"));
                assertNotNull(feedback);
                assertThat(feedback.getEmail(), equalTo("fbi@gov"));
                assertThat(feedback.getMessage(), equalTo("spy"));
                assertThat(feedback.isCool(), equalTo(true));
                sendRan = true;
            }
        });

        Feedback feedback = new Feedback();
        feedback.setCool(true);
        feedback.setEmail("fbi@gov");
        feedback.setMessage("spy");

        mockMvc.perform(post("/feedback")
                .flashAttr("feedback", feedback)
                .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(view().name("feedback/result"))
                .andExpect(model().attributeExists("feedback"))
                .andExpect(model().attribute("feedback",
                        hasProperty("email", equalTo("fbi@gov"))))
                .andExpect(model().attribute("feedback",
                        hasProperty("message", equalTo("spy"))));

        assertTrue(sendRan);
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

    @Test
    public void jsImportJquery() throws Exception {
        mockMvc.perform(get("/webjars/jquery/jquery.min.js"))
                .andExpect(status().isOk());
    }

    @Test
    public void jsImportBootstrap() throws Exception {
        mockMvc.perform(get("/webjars/bootstrap/js/bootstrap.min.js"))
                .andExpect(status().isOk());
    }

    @Test
    public void cssImportFontAwesome() throws Exception {
        mockMvc.perform(get("/webjars/font-awesome/css/font-awesome.min.css"))
                .andExpect(status().isOk());
    }
}

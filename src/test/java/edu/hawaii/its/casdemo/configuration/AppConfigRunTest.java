package edu.hawaii.its.casdemo.configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = { SpringBootWebApplication.class })
public class AppConfigRunTest {

    @Test
    public void construction() {
        AppConfig appConfig = new AppConfig();
        assertNotNull(appConfig);
        appConfig.init();
    }

}

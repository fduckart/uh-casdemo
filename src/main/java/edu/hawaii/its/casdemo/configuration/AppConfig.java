package edu.hawaii.its.casdemo.configuration;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Profile(value = { "default", "dev" })
@Configuration
@ComponentScan(basePackages = "edu.hawaii.its.casdemo")
@EnableJpaRepositories(basePackages = { "edu.hawaii.its.casdemo.repository" })
@PropertySource("classpath:custom.properties")
public class AppConfig {

    private static final Log logger = LogFactory.getLog(AppConfig.class);

    @PostConstruct
    public void init() {
        logger.info("AppConfig init");
    }

}

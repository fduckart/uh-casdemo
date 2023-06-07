package edu.hawaii.its.casdemo.configuration;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Profile(value = { "localhost", "test" })
@Configuration
@ComponentScan(basePackages = "edu.hawaii.its.casdemo")
@EnableJpaRepositories(basePackages = { "edu.hawaii.its.casdemo.repository" })
@EntityScan(basePackages = { "edu.hawaii.its.casdemo" })
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource(value = "file:${user.home}/.${user.name}-conf/casdemo-overrides.properties",
                ignoreResourceNotFound = true)
})
public class AppConfigRun {

    private static final Log logger = LogFactory.getLog(AppConfigRun.class);

    @PostConstruct
    public void init() {
        logger.info("AppConfigRun init");
    }
}

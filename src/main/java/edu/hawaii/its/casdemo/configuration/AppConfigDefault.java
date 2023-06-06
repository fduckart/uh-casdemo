package edu.hawaii.its.casdemo.configuration;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Profile(value = "default")
@Configuration
@ComponentScan(basePackages = { "edu.hawaii.its.casdemo" },
        excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
@EntityScan(basePackages = { "edu.hawaii.its.casdemo" })
@EnableJpaRepositories(basePackages = { "edu.hawaii.its.casdemo.repository" })
@EnableTransactionManagement
@PropertySource("classpath:custom.properties")
public class AppConfigDefault {

    private static final Log logger = LogFactory.getLog(AppConfigDefault.class);

    @PostConstruct
    public void init() {
        logger.info("AppConfig started.");
    }

}

package edu.hawaii.its.casdemo.configuration;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.util.Assert;

@Configuration
// @EnableTransactionManagement
public class DatabaseConfig {

    private static final Log logger = LogFactory.getLog(DatabaseConfig.class);

    @Value("${app.datasource.url}")
    private String url;

    @Value("${app.datasource.username}")
    private String username;

    @Value("${app.datasource.password}")
    private String password;

    @Value("${app.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${app.jpa.show-sql}")
    private String hibernateShowSql;

    @Value("${app.jpa.hibernate.ddl-auto}")
    private String hibernateHbm2ddlAuto;

    @Value("${app.jpa.properties.hibernate.dialect}")
    private String hibernateDialect;

    @Value("${app.jpa.properties.hibernate.cache.provider_class}")
    private String hibernateCacheProviderClass;

    @Value("${app.jpa.properties.hibernate.connection.shutdown}")
    private String hibernateConnectionShutdown;

    @PostConstruct
    public void init() {
        Assert.hasLength(url, "property 'url' is required");
        Assert.hasLength(username, "property 'user' is required");
        Assert.hasLength(driverClassName, "property 'driverClassName' is required");
        Assert.hasLength(hibernateCacheProviderClass, "property 'hibernateCacheProviderClass' is required");

        logger.info("url: " + url);
        logger.info("username: " + username);
        logger.info("DatabaseConfig started.");
    }

    // @Bean(name = "dataSource")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    // @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setPersistenceUnitName("casdemoPersistenceUnit");
        em.setDataSource(dataSource());
        em.setPackagesToScan("edu.hawaii.its.casdemo.type");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(jpaProperties());
        em.setDataSource(dataSource());

        return em;
    }

    protected Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", hibernateDialect);
        properties.setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        properties.setProperty("hibernate.cache.provider_class", hibernateCacheProviderClass);
        properties.setProperty("hibernate.connection.shutdown", hibernateConnectionShutdown);
        properties.setProperty("hibernate.show_sql", hibernateShowSql);

        return properties;
    }

}

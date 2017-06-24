package edu.hawaii.its.casdemo.configuration;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
                new ConcurrentMapCache("default"),
                new ConcurrentMapCache("applicationTypes"),
                new ConcurrentMapCache("applicationTypesById"),
                new ConcurrentMapCache("applicationRoleById"),
                new ConcurrentMapCache("campuses"),
                new ConcurrentMapCache("campusesAll"),
                new ConcurrentMapCache("campusesActualAll"),
                new ConcurrentMapCache("campusesById"),
                new ConcurrentMapCache("holidays"),
                new ConcurrentMapCache("holidaysById"),
                new ConcurrentMapCache("holidayTypes"),
                new ConcurrentMapCache("holidayTypesById"),
                new ConcurrentMapCache("personCache"),
                new ConcurrentMapCache("personByIdCache"),
                new ConcurrentMapCache("roles"),
                new ConcurrentMapCache("rolesById"),
                new ConcurrentMapCache("rolesCache"),
                new ConcurrentMapCache("rolesByIdCache"),
                new ConcurrentMapCache("messages")));
        return cacheManager;
    }

}
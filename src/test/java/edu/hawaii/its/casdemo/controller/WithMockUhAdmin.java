package edu.hawaii.its.casdemo.controller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.security.test.context.support.WithSecurityContext;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockAdminSecurityContextFactory.class)
public @interface WithMockUhAdmin {
    String username() default "admin";

    String[] roles() default { "ROLE_USER", "ROLE_ADMIN" };

    String uhuuid() default "12345679";

    String name() default "Admin";
}

package edu.hawaii.its.casdemo.access;

import java.util.LinkedHashMap;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DelegatingAuthenticationFailureHandler
        extends org.springframework.security.web.authentication.DelegatingAuthenticationFailureHandler {

    public DelegatingAuthenticationFailureHandler(String appUrlError) {
        super(new LinkedHashMap<Class<? extends org.springframework.security.core.AuthenticationException>,
                      org.springframework.security.web.authentication.AuthenticationFailureHandler>() {{
                  put(UsernameNotFoundException.class, new edu.hawaii.its.casdemo.access.AuthenticationFailureHandler(appUrlError));
                  put(AccountExpiredException.class, (request, response, e) -> response.sendRedirect(appUrlError));
              }},
                new AuthenticationFailureHandler(appUrlError));
    }
}

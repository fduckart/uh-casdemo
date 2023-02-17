package edu.hawaii.its.casdemo.access;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.AuthenticationException;

import edu.hawaii.its.casdemo.configuration.SecurityConfig;
import edu.hawaii.its.casdemo.configuration.SpringBootWebApplication;

@SpringBootTest(classes = { SpringBootWebApplication.class })
public class DelegatingAuthenticationFailureHandlerTest {

    @Value("${app.url.error-login}")
    private String appUrlError;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Autowired
    private SecurityConfig config;

    private org.springframework.security.web.authentication.AuthenticationFailureHandler handler;

    @Test
    public void handleByDefaultHandler() throws Exception {
        handler = config.authenticationFailureHandler();

        AuthenticationException exception = new AccountExpiredException("");
        handler.onAuthenticationFailure(request, response, exception);

        verify(response, times(1)).sendRedirect(appUrlError);
    }

}

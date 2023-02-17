package edu.hawaii.its.casdemo.access;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;

public class AuthenticationFailureHandlerTest {

    @Test
    public void misc() throws IOException {
        String baseUrl = "http://test.hawaii.edu/casdemo";
        String errorUrl = baseUrl + "/error-login";
        AuthenticationFailureHandler handler = new AuthenticationFailureHandler(errorUrl);
        assertThat(handler.getRedirectUrl(), equalTo(errorUrl));

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = mock(MockHttpServletResponse.class);
        BadCredentialsException exception = new BadCredentialsException("Testing Exception!");
        assertThat(request, notNullValue());
        assertThat(request, notNullValue());

        handler.onAuthenticationFailure(request, response, exception);

        verify(response, times(1)).sendRedirect(errorUrl);

    }
}

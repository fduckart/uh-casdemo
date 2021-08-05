package edu.hawaii.its.casdemo.access;

import java.util.Date;
import java.util.Map;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.authentication.AttributePrincipalImpl;
import org.jasig.cas.client.validation.Assertion;

public class AssertionDummy implements Assertion {

    private static final long serialVersionUID = 11L;

    private String username;

    // Constructor.
    public AssertionDummy() {
        // Empty.
    }

    // Constructor.
    public AssertionDummy(String username) {
        this.username = username;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    @Override
    public Date getAuthenticationDate() {
        return null;
    }

    @Override
    public AttributePrincipal getPrincipal() {
        if (username != null) {
            return new AttributePrincipalImpl(username);
        }
        return null;
    }

    @Override
    public Date getValidFromDate() {
        return null;
    }

    @Override
    public Date getValidUntilDate() {
        return null;
    }

    @Override
    public boolean isValid() {
        return false;
    }

}
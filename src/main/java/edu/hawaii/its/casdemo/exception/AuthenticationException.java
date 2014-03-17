package edu.hawaii.its.casdemo.exception;

public class AuthenticationException extends Exception {

    public AuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public AuthenticationException(String msg) {
        super(msg);
    }

    public AuthenticationException(Throwable t) {
        super(t);
    }

}

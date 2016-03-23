package edu.hawaii.its.casdemo.exception;

public class AuthenticationException extends Exception {

	public static final long serialVersionUID = 2L;

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

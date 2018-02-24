package edu.hawaii.its.casdemo.type;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Feedback {

    private String message;
    private String email;
    private boolean isCool;
    private Throwable exception;
    private String exceptionStr;

    // Constructor.
    public Feedback() {
        // Empty.
    }

    public Feedback(Throwable exception) {
        this.exception = exception;
        updateExceptionStr(exception);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isCool() {
        return isCool;
    }

    public void setCool(boolean isCool) {
        this.isCool = isCool;
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
        updateExceptionStr(exception);
    }

    public String getExceptionStr() {
        return exceptionStr;
    }

    public void setExceptionStr(String exceptionStr) {
        this.exceptionStr = exceptionStr;
    }

    private void updateExceptionStr(Throwable exception) {
        this.exceptionStr = null;
        if (exception != null) {
            StringWriter sw = new StringWriter();
            exception.printStackTrace(new PrintWriter(sw));
            this.exceptionStr = sw.toString();
        }
    }

    @Override
    public String toString() {
        return "Feedback [email=" + email
                + ", message=" + message
                + ", exception=" + exception
                + ", isCool=" + isCool + "]";
    }

}

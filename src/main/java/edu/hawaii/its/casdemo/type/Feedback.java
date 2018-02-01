package edu.hawaii.its.casdemo.type;

public class Feedback {

    private String message;
    private String email;
    private boolean isCool;

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

    @Override
    public String toString() {
        return "Feedback [email=" + email
                + ", message=" + message
                + ", isCool=" + isCool + "]";
    }

}

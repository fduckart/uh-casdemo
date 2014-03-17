package edu.hawaii.its.casdemo.security;

import edu.hawaii.its.casdemo.access.User;

public class UserContextServiceDummy extends UserContextServiceImpl {

    private String username;
    private Long uhuuid;

    public UserContextServiceDummy(String username, Long uhuuid) {
        this.username = username;
        this.uhuuid = uhuuid;
    }

    @Override
    public String getCurrentUsername() {
        return this.username;
    }

    @Override
    public Long getCurrentUhuuid() {
        return this.uhuuid;
    }

    @Override
    public User getCurrentUser() {
        throw new UnsupportedOperationException();
    }

}

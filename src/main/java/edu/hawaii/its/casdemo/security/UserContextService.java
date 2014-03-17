package edu.hawaii.its.casdemo.security;

import edu.hawaii.its.casdemo.access.UhAttributes;
import edu.hawaii.its.casdemo.access.User;

public interface UserContextService {
    public abstract User getCurrentUser();

    public abstract String getCurrentUsername();

    public abstract Long getCurrentUhuuid();

    public void setCurrentUhuuid(Long uhuuid);
    
    public String getAttribute(String name);
    
    public UhAttributes getAttributes();
}
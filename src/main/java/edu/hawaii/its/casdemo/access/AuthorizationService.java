package edu.hawaii.its.casdemo.access;

public interface AuthorizationService {
    public RoleHolder fetchRoles(String uhUuid);

    public RoleHolder fetchRoles(String uhUuid, boolean isAuthenticated);
}

package edu.hawaii.its.casdemo.access;

public interface AuthorizationService {
    RoleHolder fetchRoles(String uhUuid);

    RoleHolder fetchRoles(String uhUuid, boolean isAuthenticated);
}

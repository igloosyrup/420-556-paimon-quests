package com.igloosyrup.paimonquests.archived;

public enum ApplicationUserPermission {
    USER_READ("paimon-user:read"),
    USER_SAVE("paimon-user:save"),
    ADMIN_READ("admin:read"),
    ADMIN_SAVE("admin:save");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}

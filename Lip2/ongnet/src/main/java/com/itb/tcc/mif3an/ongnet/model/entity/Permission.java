package com.itb.tcc.mif3an.ongnet.model.entity;

public enum Permission {

    ADMIN_READ ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),

    DOADOR_READ ("doador:read"),
    DOADOR_UPDATE("doador:update"),
    DOADOR_CREATE("doador:create"),
    DOADOR_DELETE("doador:delete"),

    REPRESENTANTEONG_READ ("representanteong:read"),
    REPRESENTANTEONG_UPDATE("representanteong:update"),
    REPRESENTANTEONG_CREATE("representanteong:create"),
    REPRESENTANTEONG_DELETE("representanteong:delete");


    private final String permission;
    Permission(String permission) {
        this.permission = permission;
    }
    public String getPermission() {return permission;}
}

package com.itb.tcc.mif3an.ongnet.model.entity;

public enum Permission {

    ADMIN_READ ("ADMIN_READ"),
    ADMIN_UPDATE("ADMIN_UPDATE"),
    ADMIN_CREATE("ADMIN_CREATE"),
    ADMIN_DELETE("ADMIN_DELETE"),

    DOADOR_READ("DOADOR_READ"),
    DOADOR_UPDATE("DOADOR_UPDATE"),
    DOADOR_CREATE("DOADOR_CREATE"),
    DOADOR_DELETE("DOADOR_DELETE"),

    REPRESENTANTEONG_READ("REPRESENTANTEONG_READ"),
    REPRESENTANTEONG_UPDATE("REPRESENTANTEONG_UPDATE"),
    REPRESENTANTEONG_CREATE("REPRESENTANTEONG_CREATE"),
    REPRESENTANTEONG_DELETE("REPRESENTANTEONG_DELETE");


    private final String permission;
    Permission(String permission) {
        this.permission = permission;
    }
    public String getPermission() {return permission;}
}

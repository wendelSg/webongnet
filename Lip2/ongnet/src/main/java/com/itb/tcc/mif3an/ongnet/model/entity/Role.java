package com.itb.tcc.mif3an.ongnet.model.entity;

import java.util.Set;

import static com.itb.tcc.mif3an.ongnet.model.entity.Permission.*;

public enum Role {

    ADMIN (
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,
                    ADMIN_CREATE,

                    DOADOR_READ,
                    DOADOR_UPDATE,
                    DOADOR_DELETE,
                    DOADOR_CREATE,

                    REPRESENTANTEONG_READ,
                    REPRESENTANTEONG_UPDATE,
                    REPRESENTANTEONG_DELETE,
                    REPRESENTANTEONG_CREATE
            )

    ),
    DOADOR (
            Set.of(

                    DOADOR_READ,
                    DOADOR_UPDATE,
                    DOADOR_DELETE,
                    DOADOR_CREATE
            )

    ),

    REPRESENTANTEONG (
            Set.of(

                    REPRESENTANTEONG_READ,
                    REPRESENTANTEONG_UPDATE,
                    REPRESENTANTEONG_DELETE,
                    REPRESENTANTEONG_CREATE
            )

    );



    private Set<Permission> permissions;
    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}

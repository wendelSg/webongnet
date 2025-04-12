package com.itb.tcc.mif3an.ongnet.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(value = "REPRESENTANTEONG")
public class RepresentanteOng extends Usuario{

    @OneToMany(mappedBy = "representanteOng", cascade = CascadeType.ALL, fetch = FetchType.LAZY)   // 1:N  Representante para Ong
    @JsonIgnore
    private List<Ong> Ong = new ArrayList<>();
}

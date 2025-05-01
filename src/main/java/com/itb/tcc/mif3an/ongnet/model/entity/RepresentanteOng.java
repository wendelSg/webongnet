package com.itb.tcc.mif3an.ongnet.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(value = "REPRESENTANTEONG")
public class RepresentanteOng extends Usuario{

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)                       //N:1 Ong para representanteOng
    @JoinColumn (name = "ong_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Ong ong;
}

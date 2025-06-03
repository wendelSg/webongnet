package com.itb.tcc.mif3an.ongnet.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(value = "REPRESENTANTEONG")
public class RepresentanteOng extends Usuario{

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)                       //N:1 Ong para representanteOng
    @JoinColumn (name = "ong_id", referencedColumnName = "id", nullable = true)
    private Ong ong;

    public Ong getOng() {
        return ong;
    }
    public void setOng(Ong ong) {this.ong = ong;}

}

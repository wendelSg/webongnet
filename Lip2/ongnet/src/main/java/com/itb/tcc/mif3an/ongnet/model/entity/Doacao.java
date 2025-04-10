package com.itb.tcc.mif3an.ongnet.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "doacao")
@Data
public class Doacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate data;
    private Boolean codStatus;

    @OneToMany(mappedBy = "doacao", cascade = CascadeType.LAZY)
    @JsonIgnore
    private List<ItemDoacao> itensDoacao = new ArrayList<>();

    @Transient
    @JsonIgnore
    private String mensagemErro = "";

    @Transient
    @JsonIgnore
    private boolean isValid = true;

    public boolean validarDoacao() {
        return isValid;
    }
}

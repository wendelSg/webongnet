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

    @OneToMany(mappedBy = "doacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)  //1:N  Doacao para itensDoacao
    @JsonIgnore
    private List<ItemDoacao> itensDoacao = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)                       //N:1  Doador para doacao
    @JoinColumn (name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Doador doador;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)                       //N:1  Ong para doacao
    @JoinColumn (name = "ong_id", referencedColumnName = "id", nullable = false)
    private Ong ong;


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

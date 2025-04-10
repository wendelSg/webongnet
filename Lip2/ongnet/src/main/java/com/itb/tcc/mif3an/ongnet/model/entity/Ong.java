package com.itb.tcc.mif3an.ongnet.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "ong")
@Data
public class Ong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 20)
    private Long cnpj;
    @Column(nullable = false, length = 15)
    private String cep;
    @Column(nullable = false, length = 50)
    private String numero;
    @Column(nullable = true, length = 15)
    private Long telefone;
    @Column(nullable = false, length = 50)
    private String email;
    private Boolean codStatus;

    @Transient
    @JsonIgnore
    private String mensagemErro = "";

    @Transient
    @JsonIgnore
    private boolean isValid = true;

    public boolean validarOng() {
        return isValid;
    }
}

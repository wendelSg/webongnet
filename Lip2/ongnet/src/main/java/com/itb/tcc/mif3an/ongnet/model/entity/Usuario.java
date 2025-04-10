package com.itb.tcc.mif3an.ongnet.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "usuario")
//
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "role")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RepresentanteOng.class, name="REPRESENTANTEONG"),
        @JsonSubTypes.Type(value = Admin.class, name="ADMIN"),
        @JsonSubTypes.Type(value = Doador.class, name="DOADOR"),
})
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 45)
    private String email;
    @Column(nullable = false, length = 255)
    private String password;
    @Column(nullable = true, length = 15)
    private String cep;
    @Column(nullable = true, length = 15)
    private String telefone;
    @Column(nullable = true, length = 20)
    private String cpf;
    private Boolean codStatus;
    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private Role role;
    @Transient
    @JsonIgnore
    private String mensagemErro = "";

    @Transient
    @JsonIgnore
    private boolean isValid = true;

    public boolean validarUsuario() {
        return isValid;
    }
}

package com.itb.tcc.mif3an.ongnet.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Usuario")
//
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "role")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RepresentanteOng.class, name="REPRESENTANTEONG"),
        @JsonSubTypes.Type(value = Admin.class, name="ADMIN"),
        @JsonSubTypes.Type(value = Doador.class, name="DOADOR"),
})
@EnableJpaAuditing
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 255)
    private String password;
    @Column(nullable = false, length = 9)
    private String cep;
    @Column(nullable = true, length = 14)
    private String telefone;
    @Column(nullable = false, length = 14)
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

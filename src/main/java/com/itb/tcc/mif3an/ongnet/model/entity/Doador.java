package com.itb.tcc.mif3an.ongnet.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(value = "DOADOR")
@Data
public class Doador extends Usuario {



    @OneToMany(mappedBy = "doador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)   // 1:N de doador para doacoes
    @JsonIgnore
    private List<Doacao> doacoes = new ArrayList<>();



}

package com.itb.tcc.mif3an.ongnet.model.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "DOADOR")
public class Doador extends Usuario {
}

package com.example.msscolarite.Model;

import lombok.Data;

@Data
public class Formation {
    private long idFormation;
    private  String nom;

    public Formation(long idFormation, String nom, int duree) {
        this.idFormation = idFormation;
        this.nom = nom;
        this.duree = duree;
    }

    private int duree;


}

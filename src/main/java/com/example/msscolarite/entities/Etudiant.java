package com.example.msscolarite.entities;


import com.example.msscolarite.Model.Formation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idEtudiant;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateN;

    private String promo;

    @Temporal(TemporalType.DATE)
    private Date dateInscription;

    @ManyToOne
    private Etablissement etablissement;

    private Long idFormation;
    @Transient //use it only in  affichage no store data
    private Formation formation;
}

package com.example.msscolarite.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "formation",types={Etudiant.class})
public interface ProjectionEtudiantF {
    @Value("#{target.nom}")
    public String getNomEtudiant();
    @Value("#{target.etablissment.nom}")
    public String getNomEtablissement();

}

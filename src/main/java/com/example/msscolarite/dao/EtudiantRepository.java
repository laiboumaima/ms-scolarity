package com.example.msscolarite.dao;

import com.example.msscolarite.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
//http://localhost:8082/etudiants/search/findEtudiantByIdFormation?idf=1&projection=toformation
    List<Etudiant> findEtudiantByIdFormation(Long idf);
}

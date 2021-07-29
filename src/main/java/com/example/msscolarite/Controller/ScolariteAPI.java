package com.example.msscolarite.Controller;

import com.example.msscolarite.Model.Formation;
import com.example.msscolarite.dao.EtudiantRepository;
import com.example.msscolarite.entities.Etudiant;
import com.example.msscolarite.proxy.FormationProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import java.util.List;

@RestController
@RequestMapping("api")
public class ScolariteAPI {
  @Autowired
    EtudiantRepository etudiantRepository;

  @Autowired
  FormationProxy formationProxy;

  @GetMapping("etudiant/{id}")
    public Etudiant getEtudiantwithformation(@PathVariable("id") Long ide){

      Etudiant etudiant =etudiantRepository.findById(ide).get();
      Formation formation=formationProxy.getFormation(etudiant.getIdFormation());
      etudiant.setFormation(formation);
      return etudiant;
  }
  @GetMapping("etudiants/all")
  public List<Etudiant> getEtudiantwithFormation(){
    List<Etudiant> etudiants=etudiantRepository.findAll();
    etudiants.forEach((e)->{e.setFormation(formationProxy.getFormation(e.getIdFormation()));});
   return etudiants;
  }


}

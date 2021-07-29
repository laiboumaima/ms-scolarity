package com.example.msscolarite.Controller;

import com.example.msscolarite.Model.Formation;
import com.example.msscolarite.dao.EtudiantRepository;
import com.example.msscolarite.entities.Etudiant;
import com.example.msscolarite.proxy.FormationProxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ScolariteAPITest {
    // to mock
@Mock
    private EtudiantRepository etudiantRepository;
    // to mock
    @Mock
    private FormationProxy formationProxy;
    //class undertest
    @InjectMocks
    private ScolariteAPI scolariteAPI;
    @BeforeEach
    void setUp() {
        etudiantRepository = mock(EtudiantRepository.class);
        formationProxy = mock(FormationProxy.class);
        //MockitoAnnotations.openMocks(this); initializes fields annotated with Mockito annotations.
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void getEtudiantwithformation() {
        Etudiant etudiant =new Etudiant(1L,"oumaima", Date.valueOf("1995-11-22"),"4siw",null,null,2L,null);
        Formation formation = new Formation(2L,"springboot",20);
        when(etudiantRepository.findById(1l)).thenReturn(java.util.Optional.of(etudiant));
        when(formationProxy.getFormation(etudiant.getIdFormation())).thenReturn(formation);

        Etudiant student = scolariteAPI.getEtudiantwithformation(1L);
        System.out.println(student);
        assertEquals(student,etudiant);


    }

    @Test
    void getEtudiantwithFormation() {

    }
}
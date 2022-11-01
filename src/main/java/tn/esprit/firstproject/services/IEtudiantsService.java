package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Etudiants;

import java.util.List;

public interface IEtudiantsService {
    List<Etudiants> retrieveAllEtudiants();
    Etudiants addEtudiant (Etudiants e);
    Etudiants updateEtudiant (Etudiants e);
    Etudiants retrieveEtudiant(Integer idEtudiant);
    void removeEtudiant(Integer idEtudiant);

}

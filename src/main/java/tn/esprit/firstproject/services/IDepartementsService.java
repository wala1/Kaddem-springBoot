package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Departements;

import java.util.List;

public interface IDepartementsService  {
    List<Departements> retrieveAllDepartements();
    Departements addDepartement (Departements d);
    Departements updateDepartement (Departements d);
    Departements retrieveDepartement (Integer idDepart);
    void assignEtudiantToDepartement(Integer idDepart,Integer idEtud);
}

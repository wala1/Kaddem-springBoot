package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Departements;
import tn.esprit.firstproject.reposotories.IDepartementsRepository;

import java.util.List;

public interface IDepartementsService  {
    List<Departements> retrieveAllDepartements();
    Departements addDepartement (Departements d);
    Departements updateDepartement (Departements d);
    Departements retrieveDepartement (Integer idDepart);
    Departements affecterEtudiant(Integer idDepart,Integer idEtud);
}

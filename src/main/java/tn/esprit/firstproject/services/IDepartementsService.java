package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Departements;

import java.util.List;

public interface IDepartementsService  {
    List<Departements> retrieveAllDepartements();
    Departements addDepartement (Departements d);
    Departements updateDepartement (Departements d);
    Departements retrieveDepartement (Integer idDepart);
    Departements AffectDepartementToStudent(Integer idDepart,Integer idEtud);
}

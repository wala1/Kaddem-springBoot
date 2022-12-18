package tn.esprit.kaddemspringbootproject.services;

import tn.esprit.kaddemspringbootproject.entities.Equipe;
import tn.esprit.kaddemspringbootproject.entities.Projet;
import tn.esprit.kaddemspringbootproject.entities.Tache;

import java.util.Date;
import java.util.List;


public interface ITacheServices {
    List<Tache> retrieveAllTaches();
    Tache addTache(Tache t);
    Tache updateTache(Tache t,Integer idTache);
    void removeTache(Integer idTache);
    void removeAllTache();
    Tache retrieveTache(Integer idTache);
    List<Tache> getTacheByProjetId(Integer idProjet);
    Tache addAndAssignTacheToProjet(Tache t, Integer idProjet);
    Integer nbrTacheOfProjectBetweenTwoDateValide(Integer idProjet, Date startDate, Date finDate);
    void evaluerTache();
}

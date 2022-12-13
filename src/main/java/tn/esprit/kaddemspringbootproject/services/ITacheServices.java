package tn.esprit.kaddemspringbootproject.services;

import tn.esprit.kaddemspringbootproject.entities.Tache;

import java.util.List;


public interface ITacheServices {
    List<Tache> retrieveAllTaches();
    Tache addTache(Tache t);
    Tache updateTache(Tache t,Integer idTache);
    void removeTache(Integer idTache);
    void removeAllTache();
    Tache retrieveTache(Integer idTache);
    List<Tache> getTacheByProjetId(Integer idProjet);
}

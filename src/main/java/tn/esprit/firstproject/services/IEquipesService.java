package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Equipes;

import java.util.List;

public interface IEquipesService{
    List<Equipes> retrieveAllEquipes();
    Equipes addEquipe(Equipes e); // ajouter l’équipe avec son détail
    Equipes updateEquipe (Equipes e);
    Equipes retrieveEquipe (Integer idEquipe);
}

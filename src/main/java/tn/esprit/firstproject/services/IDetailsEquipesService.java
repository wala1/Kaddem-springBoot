package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Equipes;
import tn.esprit.firstproject.entities.detailsEquipes;
import tn.esprit.firstproject.reposotories.IDetailsEquipesRepository;

import java.util.List;

public interface IDetailsEquipesService {
    List<detailsEquipes> retrieveAllDetailsEquipes();
    detailsEquipes addDetailsEquipe(detailsEquipes e);
    detailsEquipes updateDetailsEquipe (detailsEquipes e);
    detailsEquipes retrieveDetailsEquipe (Integer idDetailsEquipe);
}

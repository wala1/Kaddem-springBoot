package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.detailsEquipes;

import java.util.List;

public interface IDetailsEquipesService {
    List<detailsEquipes> retrieveAllDetailsEquipes();
    detailsEquipes addDetailsEquipe(detailsEquipes e);
    detailsEquipes updateDetailsEquipe (detailsEquipes e);
    detailsEquipes retrieveDetailsEquipe (Integer idDetailsEquipe);
}

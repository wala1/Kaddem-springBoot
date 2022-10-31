package tn.esprit.firstproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.firstproject.entities.detailsEquipes;
import tn.esprit.firstproject.reposotories.IDetailsEquipesRepository;

import java.util.List;

public class DetailsEquipesService implements IDetailsEquipesService{
    private final IDetailsEquipesRepository deR;
    @Autowired
    public DetailsEquipesService(IDetailsEquipesRepository deR) {
        this.deR = deR;
    }

    @Override
    public List<detailsEquipes> retrieveAllDetailsEquipes() {
        return deR.findAll();
    }

    @Override
    public detailsEquipes addDetailsEquipe(detailsEquipes e) {
        return deR.save(e);
    }

    @Override
    public detailsEquipes updateDetailsEquipe(detailsEquipes e) {
        return deR.save(e);
    }

    @Override
    public detailsEquipes retrieveDetailsEquipe(Integer idDetailsEquipe) {
        return deR.findById(idDetailsEquipe).orElse(null);
    }
}

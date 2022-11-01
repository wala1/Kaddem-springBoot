package tn.esprit.firstproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.detailsEquipes;
import tn.esprit.firstproject.repositories.IDetailsEquipesRepository;

import java.util.List;
@Service
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

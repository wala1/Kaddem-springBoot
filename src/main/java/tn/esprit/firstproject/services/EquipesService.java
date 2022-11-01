package tn.esprit.firstproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Equipes;
import tn.esprit.firstproject.repositories.IEquipesRepository;

import java.util.List;
@Service
public class EquipesService implements IEquipesService{
    private final IEquipesRepository er;
    @Autowired
    public EquipesService(IEquipesRepository er) {
        this.er = er;
    }

    @Override
    public List<Equipes> retrieveAllEquipes() {

        return er.findAll();
    }

    @Override
    public Equipes addEquipe(Equipes e) {

        return er.save(e);
    }

    @Override
    public Equipes updateEquipe(Equipes e) {

        return er.save(e);
    }

    @Override
    public Equipes retrieveEquipe(Integer idEquipe) {

        return er.findById(idEquipe).orElse(null);
    }

}

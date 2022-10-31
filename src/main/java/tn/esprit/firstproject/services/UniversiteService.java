package tn.esprit.firstproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.firstproject.entities.Universite;
import tn.esprit.firstproject.reposotories.IUniversiteRepository;

import java.util.List;

public class UniversiteService implements IUniversiteService{
    private final IUniversiteRepository ur;
    @Autowired
    public UniversiteService(IUniversiteRepository ur) {
        this.ur = ur;
    }

    @Override
    public List<Universite> retrieveAllUniversites() {
        return ur.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return ur.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return ur.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return ur.findById(idUniversite).orElse(null);
    }
}

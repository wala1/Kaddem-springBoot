package tn.esprit.firstproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Etudiants;
import tn.esprit.firstproject.reposotories.IEtudiantsRepository;

import java.util.List;
@Service
public class EtudiantsService implements IEtudiantsService{
    private final IEtudiantsRepository er;
    @Autowired
    public EtudiantsService(IEtudiantsRepository er) {
        this.er = er;
    }

    @Override
    public List<Etudiants> retrieveAllEtudiants() {
        return er.findAll();
    }

    @Override
    public Etudiants addEtudiant(Etudiants e) {
        return er.save(e);
    }

    @Override
    public Etudiants updateEtudiant(Etudiants e) {
        return er.save(e);
    }

    @Override
    public Etudiants retrieveEtudiant(Integer idEtudiant) {
        return er.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
         er.deleteById(idEtudiant);

    }
}

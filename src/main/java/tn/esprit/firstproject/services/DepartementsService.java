package tn.esprit.firstproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Departements;
import tn.esprit.firstproject.entities.Etudiants;
import tn.esprit.firstproject.reposotories.IDepartementsRepository;
import tn.esprit.firstproject.reposotories.IEtudiantsRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class DepartementsService implements IDepartementsService{
    private  IDepartementsRepository dr;
    private IEtudiantsRepository er;
    private IEtudiantsService etudiantsService;

    @Override
    public List<Departements> retrieveAllDepartements() {

        return dr.findAll();
    }

    @Override
    public Departements addDepartement(Departements d) {

        return dr.save(d);
    }

    @Override
    public Departements updateDepartement(Departements d) {

        return dr.save(d);
    }

    @Override
    public Departements retrieveDepartement(Integer idDepart) {

        return dr.findById(idDepart).orElse(null);
    }

    @Override
    public Departements affecterEtudiant(Integer idDepart,Integer idEtud) {
        Etudiants etudiant=etudiantsService.retrieveEtudiant(idEtud);
        Departements departement=retrieveDepartement(idDepart);
        etudiant.setDepartements(departement);//aff
        etudiantsService.updateEtudiant(etudiant);//sauvg
        return departement;
    }

}

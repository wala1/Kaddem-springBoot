package tn.esprit.firstproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Departements;
import tn.esprit.firstproject.entities.Etudiants;
import tn.esprit.firstproject.repositories.IDepartementsRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class DepartementsService implements IDepartementsService{
    private  IDepartementsRepository departementRepository;
    private IEtudiantsService etudiantsService;

    @Override
    public List<Departements> retrieveAllDepartements() {

        return departementRepository.findAll();
    }

    @Override
    public Departements addDepartement(Departements d) {

        return departementRepository.save(d);
    }

    @Override
    public Departements updateDepartement(Departements d) {

        return departementRepository.save(d);
    }

    @Override
    public Departements retrieveDepartement(Integer idDepart) {

        return departementRepository.findById(idDepart).orElse(null);
    }

    @Override
    public Departements AffectDepartementToStudent(Integer idDepart,Integer idEtud) {
        Etudiants etudiant=etudiantsService.retrieveEtudiant(idEtud);
        Departements departement=retrieveDepartement(idDepart);
        etudiant.setDepartements(departement);//aff
        etudiantsService.updateEtudiant(etudiant);//sauvg
        return departement;
    }

}

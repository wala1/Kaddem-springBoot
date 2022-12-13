package tn.esprit.kaddemspringbootproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspringbootproject.entities.Projet;
import tn.esprit.kaddemspringbootproject.entities.Tache;
import tn.esprit.kaddemspringbootproject.repositories.IProjetRepository;
import tn.esprit.kaddemspringbootproject.repositories.ITacheRepository;

import java.time.LocalDateTime;
import java.util.List;
@Service("TacheServices")
@RequiredArgsConstructor
public class TacheServices implements ITacheServices{

    private final ITacheRepository tacheRepository;
    private final IProjetRepository projetRepository;

    @Override
    public List<Tache> retrieveAllTaches() {
        return tacheRepository.retrieveAllTaches();
    }

    @Override
    public Tache addTache(Tache t) {
    return tacheRepository.save(t);
    }
    @Override
    public Tache updateTache(Tache t,Integer idTache) {
        return tacheRepository.save(t);
    }
    @Override
    public void removeTache(Integer idTache) {
        tacheRepository.deleteById(idTache);
    }
    @Override
    public void removeAllTache() {
        tacheRepository.deleteAll();
    }
    @Override
    public Tache retrieveTache(Integer idTache) {
        return tacheRepository.findById(idTache).get();
    }

    @Override
    public List<Tache> getTacheByProjetId(Integer idProjet) {
        List<Tache> taches = tacheRepository.findByProjet_IdProjet(idProjet);
        return taches;
    }


}

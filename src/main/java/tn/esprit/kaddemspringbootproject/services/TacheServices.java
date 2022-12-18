package tn.esprit.kaddemspringbootproject.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspringbootproject.entities.Etat;
import tn.esprit.kaddemspringbootproject.entities.Projet;
import tn.esprit.kaddemspringbootproject.entities.Tache;
import tn.esprit.kaddemspringbootproject.entities.Type;
import tn.esprit.kaddemspringbootproject.repositories.IProjetRepository;
import tn.esprit.kaddemspringbootproject.repositories.ITacheRepository;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
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

    @Override
    public Tache addAndAssignTacheToProjet(Tache t, Integer idProjet) {
        Projet projet = projetRepository.findById(idProjet).get();
        t.setProjet(projet);
        return tacheRepository.save(t);
    }

    @Override
    public Integer nbrTacheOfProjectBetweenTwoDateValide(Integer idProjet, Date startDate, Date finDate) {
        Projet projet = projetRepository.findById(idProjet).get();
        Integer nbTache=0;
        Set<Tache> taches =projet.getTache();
        for(Tache tache:taches){
            if( (tache.getCreated().after(startDate) && tache.getCreated().before(finDate))
                    || (tache.getUpdated().after(startDate) && tache.getUpdated().before(finDate))
                    || (tache.getCreated().before(startDate) &&tache.getUpdated().after(finDate))
            ) {
                nbTache = nbTache + 1;
            }
        }
        return nbTache;
    }

    @Scheduled(cron = "*/15 * * * * *")
    @Override
    public void evaluerTache(){
        List<Tache> taches = tacheRepository.findAll();

        for (Tache tache : taches) {
            if(tache.getType() == Type.EPIC || tache.getType() == Type.STORY){
                if(this.isProjectTacheMoreThanOneYear(tache.getProjet())) {
                    log.info("Issue type is EPIC or STORY!!!");
                    if (tache.getEtat() == Etat.TODO) {
                        tache.setEtat(Etat.INPROGRESS);
                        tacheRepository.save(tache);
                    } else if (tache.getEtat() == Etat.INPROGRESS) {
                        tache.setEtat(Etat.CODEREVIEW);
                        tacheRepository.save(tache);
                    } else {
                        tache.setEtat(Etat.DONE);
                        tacheRepository.save(tache);
                    }
                }
            }else {
                log.info("l'issue "+tache.getNomTache()+" ne respecte pas la condition");
            }
        }

    }

    public Boolean isProjectTacheMoreThanOneYear(Projet projet){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Date today1 = new Date();

       long debCont = projet.getDateFinProjet().getTime();
       long timeDiff = Math.abs(debCont - today1.getTime());
       long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
       if(daysDiff >= 365){
           return true;
       }
       return false;
    }


}

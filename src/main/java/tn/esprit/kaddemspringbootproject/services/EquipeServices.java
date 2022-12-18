package tn.esprit.kaddemspringbootproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspringbootproject.entities.*;
import tn.esprit.kaddemspringbootproject.repositories.IDetailEquipeRepository;
import tn.esprit.kaddemspringbootproject.repositories.IEquipeRepository;
import tn.esprit.kaddemspringbootproject.repositories.IProjetRepository;

import javax.transaction.Transactional;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service("EquipeServices")
@RequiredArgsConstructor
public class EquipeServices implements IEquipeServices{

    private final IEquipeRepository equipeRepository;
    private final IDetailEquipeRepository detailEquipeRepository;
    private final IProjetRepository projetRepository;


    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepository.retrieveAllEquipes();
    }
    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public void removeEquipe(Integer idEquipe) {
        equipeRepository.deleteById(idEquipe);
    }
    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }
    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).get();
    }

    @Override
    public void removeAllEquipe() {
        equipeRepository.deleteAll();
    }

    @Override
    public void affecteEquipeToDetailEquipe(Integer idEquipe, Integer idDetailE){
        DetailEquipe dE=detailEquipeRepository.findByIdDetailEquipe(idDetailE);
        Equipe eq=retrieveEquipe(idEquipe);
        eq.setDetail_equipe(dE);//affecter departement au etudiant objet
        equipeRepository.save(eq);//sauvgarder l'objet
    }

    @Override
    public void faireEvoluerEquipes() {

    }

    @Override
    @Transactional
    public Equipe addAndAssignEquipeToDetailEquipeAndToProject(Equipe e,Integer idDetailEquipe, Integer idProjet) {
        //Get object
        DetailEquipe detailEquipe = detailEquipeRepository.findById(idDetailEquipe).orElse(null);
        Projet projet = projetRepository.findById(idProjet).orElse(null);

        //Set detail equipe
        e.setDetail_equipe(detailEquipe);
        equipeRepository.save(e);
        e = equipeRepository.save(e);

        Set<Projet> projets = new HashSet<>();
        projets.add(projet);
        e.setProjet(projets);
        System.out.println(e.getProjet().size());

        e = equipeRepository.save(e);
        return e ;
    }

    @Override
    public float beneficeTotalOfEquipeByIdEquipeBetweenTwoDate(Integer idEquipe, Date startDate, Date finDate){
        Equipe equipe = equipeRepository.findById(idEquipe).get();

        float benefice=0;
        Set<Projet> projets = equipe.getProjet();
        for(Projet projet:projets){
            if( (projet.getDateDebutProjet().after(startDate) && projet.getDateDebutProjet().before(finDate))
                    || (projet.getDateFinProjet().after(startDate) && projet.getDateFinProjet().before(finDate))
                    || (projet.getDateDebutProjet().before(startDate) &&projet.getDateFinProjet().after(finDate))
            ) {
                benefice = benefice + projet.getPrixProjet();
            }
        }
        return benefice;
    }

    @Override
    public Integer nbrEquipeWorkOnProjectHasOneOrMoreYear(Integer idEquipe) {
        Equipe equipe = equipeRepository.findById(idEquipe).get();
        Integer nbrEquipe = 0 ;
        Set<Projet> projets = equipe.getProjet();
        for(Projet projet :projets){
            if(this.isProjectHasOneOrMoreYear(projet)){
                nbrEquipe = nbrEquipe + 1;
            }
        }
        return nbrEquipe;
    }

    @Override
    public void addParticipantToEquipeAndCheckNumberMax(User u, Integer idEquipe) {
        Equipe equipe = equipeRepository.findById(idEquipe).get();
        if(equipe.getNbrMax() > equipe.getNbrParticipant()){
            equipe.setNbrParticipant(equipe.getNbrParticipant()+1);
            equipeRepository.save(equipe);
        }

    }

    public Boolean isProjectHasOneOrMoreYear(Projet projet){
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






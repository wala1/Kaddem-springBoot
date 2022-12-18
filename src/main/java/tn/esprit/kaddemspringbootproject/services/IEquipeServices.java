package tn.esprit.kaddemspringbootproject.services;

import tn.esprit.kaddemspringbootproject.entities.DetailEquipe;
import tn.esprit.kaddemspringbootproject.entities.Equipe;
import tn.esprit.kaddemspringbootproject.entities.Projet;
import tn.esprit.kaddemspringbootproject.entities.User;

import java.util.Date;
import java.util.List;

public interface IEquipeServices {

    List<Equipe> retrieveAllEquipes();
    Equipe addEquipe(Equipe e);
    Equipe updateEquipe(Equipe e);
    void removeEquipe(Integer idEquipe);
    Equipe retrieveEquipe(Integer idEquipe);
    void removeAllEquipe();
    void affecteEquipeToDetailEquipe(Integer idEquipe, Integer idDetailE);
    void faireEvoluerEquipes();
    Equipe addAndAssignEquipeToDetailEquipeAndToProject(Equipe e, Integer de, Integer idProjet);
    float beneficeTotalOfEquipeByIdEquipeBetweenTwoDate(Integer idEquipe, Date startDate, Date finDate);
    Integer nbrEquipeWorkOnProjectHasOneOrMoreYear(Integer idEquipe);
    void addParticipantToEquipeAndCheckNumberMax(User u,  Integer idEquipe);
}
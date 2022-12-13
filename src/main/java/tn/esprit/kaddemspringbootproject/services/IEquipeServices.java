package tn.esprit.kaddemspringbootproject.services;

import tn.esprit.kaddemspringbootproject.entities.DetailEquipe;
import tn.esprit.kaddemspringbootproject.entities.Equipe;
import tn.esprit.kaddemspringbootproject.entities.Projet;

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
}
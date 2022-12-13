package tn.esprit.kaddemspringbootproject.services;

import tn.esprit.kaddemspringbootproject.entities.DetailEquipe;

import java.util.List;

public interface IDetailEquipeServices {

    List<DetailEquipe> retrieveAllDetailEquipe();
    DetailEquipe addDetailEquipe(DetailEquipe detailEquipe);
    DetailEquipe updateDetailEquipe(DetailEquipe detailEquipe);
    void removeDetailEquipe(Integer idDetailEquipe);
    DetailEquipe  retrieveDetailEquipe(Integer idDetailEquipe);
    void removeAllDetailEquipe();
    DetailEquipe getDetailEquipeByEquipeId(Integer idEquipe);
}

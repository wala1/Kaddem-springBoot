package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.kaddemspringbootproject.entities.DetailEquipe;

import java.util.List;

public interface IDetailEquipeRepository extends CrudRepository<DetailEquipe, Integer> {
    @Query("select d from DetailEquipe d inner join d.equipe equipe where equipe.idEquipe = ?1")
    DetailEquipe findByEquipe_IdEquipe(Integer idEquipe);

    @Query("Select dE from DetailEquipe dE")
    List<DetailEquipe> retrieveAllDetailEquipe();

    @Query("select d from DetailEquipe d where d.idDetailEquipe = ?1")
    DetailEquipe findByIdDetailEquipe(Integer idDetailEquipe);
}
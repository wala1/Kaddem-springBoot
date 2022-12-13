package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.kaddemspringbootproject.entities.Tache;

import java.util.List;

public interface ITacheRepository extends CrudRepository<Tache,Integer>{
    @Query("select t from Tache t where t.projet.idProjet = ?1")
    List<Tache> findByProjet_IdProjet(Integer idProjet);


    @Query("Select t from Tache t")
    List<Tache> retrieveAllTaches();
}

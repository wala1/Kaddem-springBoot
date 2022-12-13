package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.kaddemspringbootproject.entities.Equipe;
import tn.esprit.kaddemspringbootproject.entities.Projet;

import java.util.List;

public interface IProjetRepository extends CrudRepository<Projet,Integer> {

    @Query("Select p from Projet p")
    List<Projet> retrieveAllProjet();

    @Query("select p from Projet p where p.idProjet = ?1")
    Projet findByIdProjet(Integer idProjet);

    @Query("select p from Projet p where p.nomProjet = ?1")
    Projet findByNomProjet(String nomProjet);


}

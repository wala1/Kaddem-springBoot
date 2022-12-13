package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.kaddemspringbootproject.entities.Equipe;
import tn.esprit.kaddemspringbootproject.entities.User;

import java.util.List;

public interface IEquipeRepository extends CrudRepository<Equipe, Integer> {

    @Query("Select eq from Equipe eq")
    List<Equipe> retrieveAllEquipes();

    @Query("select e from Equipe e where e.contrat = ?1")
    Equipe findByEtudiant(User user);

}

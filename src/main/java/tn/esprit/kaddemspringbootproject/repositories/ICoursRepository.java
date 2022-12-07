package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.kaddemspringbootproject.entities.Cours;
import tn.esprit.kaddemspringbootproject.entities.categorieCours;

import java.util.List;

public interface ICoursRepository extends JpaRepository<Cours,Integer> {
List<Cours> findByCategorieCours(categorieCours cat);
List<Cours> findByUniversite_IdUniv(Integer idUniv);
}

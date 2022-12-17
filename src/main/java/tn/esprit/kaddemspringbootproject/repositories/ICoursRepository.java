package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.kaddemspringbootproject.entities.Cours;
import tn.esprit.kaddemspringbootproject.entities.categorieCours;

import java.util.List;

public interface ICoursRepository extends JpaRepository<Cours,Integer> {
List<Cours> findByCategorieCours(categorieCours cat);
List<Cours> findByUniversite_IdUniv(Integer idUniv);
@Query("select c from Cours c order by c.prixCours asc ")
List<Cours> CoursOrderByPriceASC();
@Query("select c from Cours c order by c.prixCours desc ")
List<Cours> CoursOrderByPriceDESC();
List<Cours> findByPromotionNotNull();
}

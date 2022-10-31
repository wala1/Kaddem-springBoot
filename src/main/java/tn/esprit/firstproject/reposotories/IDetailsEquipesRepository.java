package tn.esprit.firstproject.reposotories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.detailsEquipes;
@Repository
public interface IDetailsEquipesRepository extends JpaRepository<detailsEquipes,Integer> {
}

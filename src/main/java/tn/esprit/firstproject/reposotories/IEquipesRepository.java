package tn.esprit.firstproject.reposotories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Equipes;
@Repository
public interface IEquipesRepository extends JpaRepository<Equipes,Integer> {
}

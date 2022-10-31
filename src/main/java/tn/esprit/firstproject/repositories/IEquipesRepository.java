package tn.esprit.firstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Equipes;
@Repository
public interface IEquipesRepository extends JpaRepository<Equipes,Integer> {
}

package tn.esprit.firstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Etudiants;
@Repository
public interface IEtudiantsRepository extends JpaRepository<Etudiants,Integer> {
}
package tn.esprit.firstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Departements;
@Repository
public interface IDepartementsRepository extends JpaRepository<Departements,Integer> {
}

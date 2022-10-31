package tn.esprit.firstproject.reposotories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Departements;
@Repository
public interface IDepartementsRepository extends JpaRepository<Departements,Integer> {
}

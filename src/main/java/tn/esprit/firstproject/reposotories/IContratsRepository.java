package tn.esprit.firstproject.reposotories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.firstproject.entities.Contrats;

@Repository
public interface IContratsRepository extends JpaRepository<Contrats,Integer> {

}

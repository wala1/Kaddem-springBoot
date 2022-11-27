package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.kaddemspringbootproject.entities.Formation;

public interface IFormationDao extends JpaRepository<Formation,Integer> {
}

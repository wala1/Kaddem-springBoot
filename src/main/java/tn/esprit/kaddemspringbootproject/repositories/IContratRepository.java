package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.kaddemspringbootproject.entities.Contrat;

public interface IContratRepository extends JpaRepository<Contrat,Integer> {
}

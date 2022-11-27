package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.kaddemspringbootproject.entities.Evenement;

public interface IEvenenemtDao extends JpaRepository<Evenement,Integer> {
}

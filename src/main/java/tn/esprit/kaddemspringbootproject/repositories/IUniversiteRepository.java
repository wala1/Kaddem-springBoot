package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.kaddemspringbootproject.entities.Universite;
import tn.esprit.kaddemspringbootproject.entities.categorieUniv;

import java.util.List;

public interface IUniversiteRepository extends JpaRepository<Universite,Integer> {
    List<Universite> findByCategorieUniv(categorieUniv cat);
    Universite findByNomUniv(String nom);

}

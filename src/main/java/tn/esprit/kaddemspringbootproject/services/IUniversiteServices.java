package tn.esprit.kaddemspringbootproject.services;

import tn.esprit.kaddemspringbootproject.entities.Universite;
import tn.esprit.kaddemspringbootproject.entities.categorieUniv;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface IUniversiteServices {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (Integer idUniversite);
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
    void removeUniv(Integer idUniv);
    List<Universite> findUnivByCategorie(categorieUniv cat);
    public  ByteArrayInputStream univesritiesPDF(List<Universite> univ);


}

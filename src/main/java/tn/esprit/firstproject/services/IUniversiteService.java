package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Universite;
import tn.esprit.firstproject.reposotories.IUniversiteRepository;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (Integer idUniversite);
}

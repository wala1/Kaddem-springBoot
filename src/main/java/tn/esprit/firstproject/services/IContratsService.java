package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Contrats;

import java.util.List;
import java.util.Optional;

public interface IContratsService  {
    List<Contrats> retrieveAllContrats();
    Contrats updateContrat (Contrats ce);
    Contrats addContrat (Contrats ce);
    Contrats retrieveContrat (Integer idContrat);
    void removeContrat(Integer idContrat);
}

package tn.esprit.kaddemspringbootproject.services;

import tn.esprit.kaddemspringbootproject.entities.Projet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public interface IProjetServices {
    List<Projet> retrieveAllProjects();
    Projet addProjet(Projet projet);
    Projet updateProjet(Projet projet,Integer idProjet);
    void removeProjet(Integer idProjet);
    Projet retrieveProjet(Integer idProjet);
    void removeAllProjet();
    ByteArrayInputStream projetsPDEFReport(List<Projet> projets);
    ByteArrayInputStream projetsExcelFReport(List<Projet> projets) throws IOException;

}

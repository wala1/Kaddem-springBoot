package com.esprit.first_project.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class Projet implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProjet ;

    private String nomProjet;
    private String descriptionProjet;
    private Float prixProjet;

    @Temporal(TemporalType.DATE)
    private Date dateDebutProjet;

    @Temporal(TemporalType.DATE)
    private Date dateFinProjet;

    private String Flyer;
}
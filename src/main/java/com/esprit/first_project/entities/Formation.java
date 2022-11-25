package com.esprit.first_project.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Formation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFormation ;

    private String nomFormation;
    private String descriptionFormation;
    private Float prixFormation;
    private Integer nbParticipantMax;
    private Integer nbParticipants;

    @Temporal(TemporalType.DATE)
    private Date dateDebutFormation;

    @Temporal(TemporalType.DATE)
    private Date dateFinFormation;

    private String Flyer;

}
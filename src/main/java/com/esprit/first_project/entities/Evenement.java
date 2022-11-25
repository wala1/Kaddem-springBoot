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
public class Evenement implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvent ;

    private String descriptionEvent;

    @Temporal(TemporalType.DATE)
    private Date dateDebutEvent;

    @Temporal(TemporalType.DATE)
    private Date dateFinEvent;

    private Integer nbParticipantMax;
    private Integer nbParticipants;
    private String image;

}

package tn.esprit.kaddemspringbootproject.entities;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Cours implements Serializable {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer idCours;
 private String nomCours;
 private String nomEnseignant;
 private String descriptionCours;
 private Float prixCours;
 @Temporal(TemporalType.DATE)
 Date dateDePublication;
 private String flyer;
 @Enumerated(EnumType.STRING)
 private Option option;
 @ManyToOne()
 Universite universite;

}

package tn.esprit.kaddemspringbootproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

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
 private Float promotion;
 @Temporal(TemporalType.DATE)
 Date dateDePublication;
 @Temporal(TemporalType.DATE)
 Date dateDebutPomotion;
 @Temporal(TemporalType.DATE)
 Date dateFinPomotion;
 private String flyer;
 @Enumerated(EnumType.STRING)
 private categorieCours categorieCours;
 @ManyToOne()

 Universite universite;

}

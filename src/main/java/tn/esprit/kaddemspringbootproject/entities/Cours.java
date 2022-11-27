package tn.esprit.kaddemspringbootproject.entities;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Cours implements Serializable {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 Integer idFormation;
 String nomFormation;
 String nomFormateur;
 String   descriptionFormation;
 Float prixFormation;
 Integer nbParticipants;
 @Temporal(TemporalType.DATE)
 Date dateDebutFormation;
 @Temporal(TemporalType.DATE)
 Date dateFinFormation;
 String flyer;
 @ManyToOne()
 Universite universite;

}

package tn.esprit.kaddemspringbootproject.entities;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Evenement  implements Serializable {


 // champs métier
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 Integer idEvent;
 String themeEvent;
 @Temporal(TemporalType.DATE)
 Date dateDebutEvent;
 @Temporal(TemporalType.DATE)
 Date dateFinEvent;
 Integer nbParticipantMax;
 String affiche;

 // champs de relation
 @ManyToMany(mappedBy = "evenements" , fetch = FetchType.LAZY , cascade = CascadeType.PERSIST)
 Set <User> etudiants ;


}

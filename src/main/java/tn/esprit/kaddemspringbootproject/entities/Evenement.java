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
public class Evenement  implements Serializable {


 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 Integer idEvent;
 String descriptionEvent;
 @Temporal(TemporalType.DATE)
 Date dateDebutEvent;
 @Temporal(TemporalType.DATE)
 Date  dateFinEvent;
 Integer nbParticipantMax;
 String image;
}

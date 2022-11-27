package tn.esprit.kaddemspringbootproject.entities;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Equipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idEquipe ;
    String nomEquipe ;
    @Enumerated(EnumType.STRING)
    Niveau niveau ;

}

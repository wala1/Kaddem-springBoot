package tn.esprit.kaddemspringbootproject.entities;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
@Entity
public class Universite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idUniv ;
    String nomUniv  ;
    String emailUniv ;
    String logoUniv ;
    @OneToMany()
    Set<Departement> departements;
    @OneToMany(mappedBy = "universite")
    Set<Cours> cours;
}

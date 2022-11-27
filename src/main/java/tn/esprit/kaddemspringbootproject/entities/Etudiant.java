package tn.esprit.kaddemspringbootproject.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant extends  Personne implements Serializable {
    Option option ;
}

package tn.esprit.firstproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
public class Etudiants implements Serializable {
    @Id
    private Integer idEtudiant;
    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)
    private Option option;
    @ManyToOne
    Departements departements;
    @ManyToMany(mappedBy = "etudiants",cascade = CascadeType.ALL)
    private Set<Equipes> equipes;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "etudiants")
    private Set<Contrats> contrats;
}

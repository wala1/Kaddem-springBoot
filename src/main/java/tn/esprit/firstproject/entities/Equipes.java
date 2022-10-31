package tn.esprit.firstproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
public class Equipes implements Serializable {
    @Id
    private Integer idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private NiveauEq niveau;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Etudiants> etudiants;
    @OneToOne
    private detailsEquipes detaileq;

}

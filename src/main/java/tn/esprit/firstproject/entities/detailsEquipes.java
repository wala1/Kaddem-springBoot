package tn.esprit.firstproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class detailsEquipes  implements Serializable {
    @Id
    private Integer idDetailEquipe;
    private Integer salle;
    private  String thematique;
    @OneToOne(mappedBy = "detaileq")
    private Equipes equipe;
}

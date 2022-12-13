package tn.esprit.kaddemspringbootproject.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class DetailEquipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  Integer idDetailEquipe;
    private Integer salle;
    private String bloc;
    private Integer etage;
    private String thematique;

    @OneToMany(mappedBy = "detail_equipe")
    private Set<Equipe> equipe;

}

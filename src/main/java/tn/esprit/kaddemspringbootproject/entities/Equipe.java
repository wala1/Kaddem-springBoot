package tn.esprit.kaddemspringbootproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Equipe implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    public Niveau niveau;
    private String logo;
    private Integer nbrMax;
    private Integer nbrParticipant;
    private Integer ratting= 1|2|3|4|5;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    private DetailEquipe detail_equipe;
    @OneToMany(mappedBy = "equipe")
    private Set<Contrat> contrat;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Set<Projet> projet;

}

package tn.esprit.kaddemspringbootproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Projet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer idProjet;
    private String nomProjet;
    private String descriptionProjet;
    private Float prixProjet;
    @Temporal(TemporalType.DATE)
    private Date dateDebutProjet;
    @Temporal(TemporalType.DATE)
    private Date dateFinProjet;
    private String logo;
    private String slogan;
    private String methodologie;
    private Integer ratting= 1|2|3|4|5;
    @ManyToMany(mappedBy = "projet")
    private Set<Equipe> equipe;
    @OneToMany(mappedBy = "projet")
    private List<Tache> tache;
}
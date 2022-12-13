package tn.esprit.kaddemspringbootproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Tache implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer idTache;
    private String nomTache;
    private String descriptionTache;
    @Enumerated(EnumType.STRING)
    private Etat etat;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Temporal(TemporalType.DATE)
    private Date created;
    @Temporal(TemporalType.DATE)
    private Date updated;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Projet projet;
}

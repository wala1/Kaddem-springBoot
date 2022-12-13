package tn.esprit.kaddemspringbootproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
@Entity
public class Contrat implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContrat;

    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;

    @Temporal(TemporalType.DATE)
    private Date dateFinContrat;

    private Boolean archive;
    private Integer montantContrat;

    @Enumerated(EnumType.STRING)
    public Specialite specialite;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    private User user;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Equipe equipe;
}

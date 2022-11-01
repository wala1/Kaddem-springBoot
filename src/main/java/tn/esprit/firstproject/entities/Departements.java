package tn.esprit.firstproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
public class Departements implements Serializable {
    @Id
    private Integer idDepart;
    private String nomDepart;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "departements")
    private Set<Etudiants> etudiants;
}

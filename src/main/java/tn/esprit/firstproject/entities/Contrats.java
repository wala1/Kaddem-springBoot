package tn.esprit.firstproject.entities;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Getter
@Setter
public class Contrats implements Serializable {
    @Id
    private Integer idContart;
    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;
    @Temporal(TemporalType.DATE)
    private Date dateFinContrat;
    private Boolean archive;
    private Integer montantContart ;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    @ManyToOne
    Etudiants etudiants;



}

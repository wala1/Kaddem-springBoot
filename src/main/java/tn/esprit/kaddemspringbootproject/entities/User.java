package tn.esprit.kaddemspringbootproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;



@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer idEtudiant;
    private String prenomE;
    private String nomE;
    private String email;
    private String password;
    private Option option;

    @Enumerated(EnumType.STRING)
    private Role role;
    private String image;

    @OneToMany(mappedBy = "user")
    private Set<Contrat> contrat;

}


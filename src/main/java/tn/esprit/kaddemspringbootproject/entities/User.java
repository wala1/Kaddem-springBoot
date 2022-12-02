package tn.esprit.kaddemspringbootproject.entities;


import lombok.*;
import lombok.experimental.FieldDefaults;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"idUser","email"})
@ToString(exclude = {"idUser" , "password"})
@RequiredArgsConstructor()
@Getter
@Setter
@AllArgsConstructor()

public class User implements Serializable {


 // champs métier
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 Integer idUser;
 String lastName ;
 String firstName ;
 String email ;
 String password;
 Option option ;
 String userPicture ;

 // champs de relation

 @OneToMany(mappedBy = "user" , fetch = FetchType.EAGER  , cascade = CascadeType.ALL)
 Set<Role> roles ;

 @ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST)
 List<Evenement> evenements ;

 @OneToOne (fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
 Universite universite ;

 @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
 Departement departement ;

 @OneToMany (mappedBy = "etudiant" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
 Set<Contrat> contrats ;


}

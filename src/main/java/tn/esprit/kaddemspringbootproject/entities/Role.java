package tn.esprit.kaddemspringbootproject.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.io.Serializable;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    // champs métier
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer idRole ;
     @Enumerated(EnumType.STRING)
     RoleName roleName ;

    // champs de relation
    @ManyToOne (cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    User user ;




}

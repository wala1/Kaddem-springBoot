package tn.esprit.kaddemspringbootproject.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = {"roleName"})
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    // champs métier
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer idRole ;
     @Enumerated(EnumType.STRING)
     RoleName roleName ;






}

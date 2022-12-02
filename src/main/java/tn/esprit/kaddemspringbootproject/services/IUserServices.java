package tn.esprit.kaddemspringbootproject.services;

import tn.esprit.kaddemspringbootproject.entities.Role;
import tn.esprit.kaddemspringbootproject.entities.User;

import java.util.List;


public interface IUserServices {

    User saveUser( User user ) ;
    Role saveRole(Role role);
    User getUser (Integer idUser);
    List<User> getAllUsers ();
    void affectRoleToUser (Integer idUser , Integer idRole);
    void addUserAddRoleWithAffect (User user ) ;
    User addUserAssignToRole (User user , Integer idRole);




}

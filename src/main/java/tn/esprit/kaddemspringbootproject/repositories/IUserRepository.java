package tn.esprit.kaddemspringbootproject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.kaddemspringbootproject.entities.User;

import java.util.List;

public interface IUserRepository extends CrudRepository<User,Integer> {

    @Query("select u from User u ")
    List<User> retrieveAllEtudiants();

    @Query("select e from User e where e.nomE = ?1 and e.prenomE = ?2")
    User findByNomEAndPrenomE(String nomE, String prenomE);



}
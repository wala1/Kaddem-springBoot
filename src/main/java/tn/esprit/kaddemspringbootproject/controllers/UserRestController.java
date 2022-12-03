package tn.esprit.kaddemspringbootproject.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspringbootproject.entities.Role;
import tn.esprit.kaddemspringbootproject.entities.User;
import tn.esprit.kaddemspringbootproject.services.UserServices;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {

   private final UserServices userServices ;


/*   //RessourceEndPoint:http://localhost:8085/Kaddem/user/add
   @PostMapping("/add")
   User addUser (@RequestBody User user)
   { return  userServices.saveUser(user);}  */


   //RessourceEndPoint:http://localhost:8085/Kaddem/user/add
   @PostMapping("/add")
   ResponseEntity <User> addUser (@RequestBody User user)
   { return  new ResponseEntity<>(userServices.saveUser(user), HttpStatus.CREATED) ;}


  /* //RessourceEndPoint:http://localhost:8085/Kaddem/user/getAll
   @GetMapping("/getAll")
   List<User> getAll ()
   { return  userServices.getAllUsers();} */


   //RessourceEndPoint:http://localhost:8085/Kaddem/user/getAll
   @GetMapping("/getAll")
     ResponseEntity< List<User> >  getAll ()
   { return  ResponseEntity.status(HttpStatus.FOUND).body(userServices.getAllUsers());}


   //RessourceEndPoint:http://localhost:8085/Kaddem/user/addRole
   @PostMapping("/addRole")
   Role addRole (@RequestBody Role role)
   { return  userServices.saveRole(role);}


   //RessourceEndPoint:http://localhost:8085/Kaddem/user/affectRoleToUser/{idU}/{idR}
   @PostMapping("/affectRoleToUser/{idU}/{roleName}")
   void  addRoleToUser (@PathVariable("idU") Integer idUser , @PathVariable("roleName") String roleName)
   { userServices.affectRoleToUser(idUser,roleName);}


/*  // We can do this simply with cascading since user is Parent
   //RessourceEndPoint:http://localhost:8085/Kaddem/user/addUserAddRoleWithAffect
   @PostMapping("/addUserAddRoleWithAffect")
   public void addUserAddRoleWithAffect( @RequestBody User user)
   { userServices.addUserAddRoleWithAffect(user);  }
*/


   //RessourceEndPoint:http://localhost:8085/Kaddem/user/addUserAssignToRole/{idR}
   @PostMapping("/addUserAssignToRole/{roleName}")
   public User addUserAssignToRole(@RequestBody User user,@PathVariable("idR") String roleName)
   { return  userServices.addUserAssignToRole(user , roleName);}


   //RessourceEndPoint:http://localhost:8085/Kaddem/user/getUserById/{idU}
   @GetMapping("/getUserById/{idU}")
   User getUserById (@PathVariable("idU")Integer idUser)
   { return  userServices.getUserById(idUser);}
}

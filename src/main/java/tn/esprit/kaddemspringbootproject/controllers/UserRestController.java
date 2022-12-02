package tn.esprit.kaddemspringbootproject.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspringbootproject.entities.Role;
import tn.esprit.kaddemspringbootproject.entities.User;
import tn.esprit.kaddemspringbootproject.services.UserServices;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {

   private final UserServices userServices ;


   //RessourceEndPoint:http://localhost:8085/Kaddem/user/add
   @PostMapping("/add")
   User addUser (@RequestBody User user)
   { return  userServices.saveUser(user);}


   //RessourceEndPoint:http://localhost:8085/Kaddem/user/addRole
   @PostMapping("/addRole")
   Role addUser (@RequestBody Role role)
   { return  userServices.saveRole(role);}


   //RessourceEndPoint:http://localhost:8085/Kaddem/user/addRoleToUser/{idU}/{idR}
   @PostMapping("/addRoleToUser/{idU}/{idR}")
   void  addRoleToUser (@PathVariable("idU") Integer idUser , @PathVariable("idR") Integer idRole)
   { userServices.affectRoleToUser(idUser,idRole);}


   //RessourceEndPoint:http://localhost:8085/Kaddem/addUserAddRoleWithAffect
   @PostMapping("/addUserAddRoleWithAffect")
   public void addUserAddRoleWithAffect( @RequestBody User user)
   { userServices.addUserAddRoleWithAffect(user);  }


   //RessourceEndPoint:http://localhost:8085/Kaddem/addUserAssignToRole/{idR}
   @PostMapping("/addUserAssignToRole/{idR}")
   public User addUserAssignToRole(@RequestBody User user,@PathVariable("idR") Integer idRole)
   { return  userServices.addUserAssignToRole(user , idRole);}



}

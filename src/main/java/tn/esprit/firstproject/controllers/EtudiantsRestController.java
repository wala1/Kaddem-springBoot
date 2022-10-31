package tn.esprit.firstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Etudiants;
import tn.esprit.firstproject.services.IEtudiantsService;
import java.util.List;
@RestController
@RequestMapping("/etudiant")
@RequiredArgsConstructor
public class EtudiantsRestController {
    private  final IEtudiantsService etudiantsService;
    @GetMapping("/all")
    public List<Etudiants> getAllStudents(){
        return etudiantsService.retrieveAllEtudiants();
    }
    @PostMapping("/add")
    public Etudiants addStudent(@RequestBody Etudiants e){
       return  etudiantsService.addEtudiant(e);
    }
    @PutMapping("update")
    public Etudiants updateStudent(@RequestBody Etudiants e){
        return etudiantsService.updateEtudiant(e);
    }
    @GetMapping("/find/{id}")
    public Etudiants findStudent(@PathVariable("id") Integer id){
        return etudiantsService.retrieveEtudiant(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") Integer id){
        etudiantsService.removeEtudiant(id);
    }
}

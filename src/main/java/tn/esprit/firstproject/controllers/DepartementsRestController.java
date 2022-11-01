package tn.esprit.firstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Departements;
import tn.esprit.firstproject.services.IDepartementsService;
import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartementsRestController {
    private  final IDepartementsService departementsService;
    @GetMapping("/all")
    public List<Departements> getAllDepartments(){
        return departementsService.retrieveAllDepartements();
    }
    @PostMapping("/add")
    public Departements addDepartment(@RequestBody Departements d){
        return  departementsService.addDepartement(d);
    }
    @PutMapping("/affect/{idDep}/{idEtud}")
    public Departements AffectDepartementToStudent(@PathVariable("idDep") Integer idDep,@PathVariable("idEtud") Integer idEtud){
        return departementsService.AffectDepartementToStudent(idDep,idEtud);
    }
    @PutMapping("/update")
    public Departements updateDepartement(@RequestBody Departements d){
        return departementsService.updateDepartement(d);
    }
    @GetMapping("/find/{id}")
    public Departements findDepartment(@PathVariable("id") Integer id){
        return departementsService.retrieveDepartement(id);
    }

}

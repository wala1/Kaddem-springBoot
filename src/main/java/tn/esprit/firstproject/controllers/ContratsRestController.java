package tn.esprit.firstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Contrats;
import tn.esprit.firstproject.services.IContratsService;

import java.util.List;

@RestController
@RequestMapping("/Contrats")
@RequiredArgsConstructor
public class ContratsRestController {
    @Autowired
    private final IContratsService contratServices;
    @GetMapping("/all")
    @ResponseBody
    public List<Contrats> retrieveAllContrats(){
        return contratServices.retrieveAllContrats();
    }

    @PutMapping("/update")
    @ResponseBody
    public Contrats updateContrat (@RequestBody Contrats ce){
        return contratServices.updateContrat(ce);
    }

    @PostMapping("/add")
    @ResponseBody
    public Contrats addContrat(@RequestBody Contrats c){
        return contratServices.addContrat(c);
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public Contrats retrieveContrat (@PathVariable("id") Integer id){
        return contratServices.retrieveContrat(id);
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public void addContrat(@PathVariable("id") Integer id){
        contratServices.removeContrat(id);
    }


}

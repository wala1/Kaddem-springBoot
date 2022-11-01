package tn.esprit.firstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Universite;
import tn.esprit.firstproject.services.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("Universite")
@RequiredArgsConstructor
public class UniversiteRestController {
    @Autowired
    private final IUniversiteService universiteServices;

    @GetMapping("/all")
    @ResponseBody
    public List<Universite> retrieveAllUniversite(){
        return universiteServices.retrieveAllUniversites();
    }

    @PostMapping("/add")
    @ResponseBody
    public Universite addUniversite(@RequestBody Universite u){
        return universiteServices.addUniversite(u);
    }

    @GetMapping("find/{id}")
    @ResponseBody
    public Universite findUniversite(@PathVariable("id") Integer idUniversite){
        return universiteServices.retrieveUniversite(idUniversite);
    }
}

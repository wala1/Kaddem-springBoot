package tn.esprit.firstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Equipes;
import tn.esprit.firstproject.services.IEquipesService;

import java.util.List;

@RestController
@RequestMapping("Equipes")
@RequiredArgsConstructor
public class EquipesRestController {
    private final IEquipesService equipeServices;

    @GetMapping("/all")
    @ResponseBody
    public List<Equipes> retrieveAllDetailEquipe(){
        return equipeServices.retrieveAllEquipes();
    }

    @PostMapping("/add")
    @ResponseBody
    public Equipes addEquipe(@RequestBody Equipes e){
        return equipeServices.addEquipe(e);
    }

    @GetMapping("find/{id}")
    @ResponseBody
    public Equipes findEquipe(@PathVariable("id") Integer idEquipe){
        return equipeServices.retrieveEquipe(idEquipe);
    }
}

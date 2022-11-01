package tn.esprit.firstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.detailsEquipes;
import tn.esprit.firstproject.services.IDetailsEquipesService;

import java.util.List;

@RestController
@RequestMapping("detailsEquipes")
@RequiredArgsConstructor
public class DetailsEquipesRestController {
    @Autowired
    private final IDetailsEquipesService detailEquipeServices;

    @GetMapping("/all")
    @ResponseBody
    public List<detailsEquipes> retrieveAllDetailEquipe(){
        return detailEquipeServices.retrieveAllDetailsEquipes();
    }

    @PostMapping("/add")
    @ResponseBody
    public detailsEquipes addDetailEquipe(@RequestBody detailsEquipes d){
        return detailEquipeServices.addDetailsEquipe(d);
    }

    @GetMapping("DetailEquipe/{id}")
    @ResponseBody
    public detailsEquipes FindDetailEquipe(@PathVariable("id") Integer idDetailEquipe){
        return detailEquipeServices.retrieveDetailsEquipe(idDetailEquipe);
    }

}

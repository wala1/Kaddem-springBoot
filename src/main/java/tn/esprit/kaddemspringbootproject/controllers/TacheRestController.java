package tn.esprit.kaddemspringbootproject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspringbootproject.entities.Tache;
import tn.esprit.kaddemspringbootproject.services.ITacheServices;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@Tag(name = "Tache Controller")
public class TacheRestController {
    @Autowired
    private final ITacheServices tacheServices;

    @GetMapping("/Tache")
    @ResponseBody
    public List<Tache> retrieveAllDetailTache(){
        return tacheServices.retrieveAllTaches();
    }

    @PostMapping("/addTache")
    @ResponseBody
    public Tache addTache(@RequestBody Tache tache){
        return tacheServices.addTache(tache);
    }

    @PutMapping("/updateTache/{id}")
    @ResponseBody
    public Tache updateTache(@RequestBody Tache tache,@PathVariable("id") Integer idTache){
        return tacheServices.updateTache(tache,idTache);
    }

    @GetMapping("Tache/{id}")
    @ResponseBody
    public void retrieveTache(@PathVariable("id") Integer idTache){
        tacheServices.retrieveTache(idTache);
    }

    @DeleteMapping("removeTache/{id}")
    @ResponseBody
    public void removeTache(@PathVariable("id") Integer idTache){
        tacheServices.removeTache(idTache);
    }

    @DeleteMapping("removeAllTache")
    @ResponseBody
    public void removeAllTache(){
        tacheServices.removeAllTache();
    }

    @GetMapping("getTacheByProjetId/{id}")
    @ResponseBody
    public List<Tache> getTacheByProjetId(@PathVariable("id") Integer idProjet){
        return tacheServices.getTacheByProjetId(idProjet);
    }

    @PutMapping("/addAndAssignTacheToProjet/{id}")
    @ResponseBody
    public Tache addAndAssignTacheToProjet(@RequestBody Tache t, @PathVariable("id")  Integer idProjet) {
        return  tacheServices.addAndAssignTacheToProjet(t,idProjet);
    }

    @GetMapping("nbrTacheOfProjectBetweenTwoDateValide/{id}/{startDate}/{finDate}")
    @ResponseBody
    public Integer nbrTacheOfProjectBetweenTwoDateValide(@PathVariable("id") Integer idProjet,
            @PathVariable("startDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @PathVariable("finDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date finDate){
        return tacheServices.nbrTacheOfProjectBetweenTwoDateValide(idProjet,startDate,finDate);
    }

    @PutMapping("/evaluerTache")
    @ResponseBody
    public void evaluerTache(){
        tacheServices.evaluerTache();
    }

}
package tn.esprit.kaddemspringbootproject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspringbootproject.entities.DetailEquipe;
import tn.esprit.kaddemspringbootproject.entities.Equipe;
import tn.esprit.kaddemspringbootproject.entities.User;
import tn.esprit.kaddemspringbootproject.services.IEquipeServices;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@Tag(name = "Equipe Controller")
public class EquipeRestController {
    @Autowired
    private final IEquipeServices equipeServices;

    @GetMapping("/Equipe")
    @ResponseBody
    public List<Equipe> retrieveAllEquipe(){
        return equipeServices.retrieveAllEquipes();
    }

    @PostMapping("/addEquipe")
    @ResponseBody
    public Equipe addEquipe(@RequestBody Equipe e){
        return equipeServices.addEquipe(e);
    }

    @PutMapping("/updateEquipe/{id}")
    @ResponseBody
    public Equipe updateEquipe(@RequestBody Equipe e,@PathVariable("id") Integer idEquipe){
        return equipeServices.updateEquipe(e);
    }

    @DeleteMapping("removeEquipe/{id}")
    @ResponseBody
    public void removeEquipe(@PathVariable("id") Integer idEquipe){
        equipeServices.removeEquipe(idEquipe);
    }

    @PutMapping("/affecteEquipeToDetailEquipe/{idEquipe}/{idDetailE}")
    public void affecteEquipeToDetailEquipe(@PathVariable("idEquipe") Integer idEquipe,@PathVariable("idDetailE") Integer idDetailE){
        equipeServices.affecteEquipeToDetailEquipe(idEquipe,idDetailE);
    }
    @GetMapping("Equipe/{id}")
    @ResponseBody
    public void retrieveEquipe(@PathVariable("id") Integer idEquipe){
        equipeServices.retrieveEquipe(idEquipe);
    }

    @PutMapping("/faireEvoluerEquipes")
    public void faireEvoluerEquipes(){
        equipeServices.faireEvoluerEquipes();
    }

    @DeleteMapping("removeAllEquipe")
    public void removeAllEquipe(){
        equipeServices.removeAllEquipe();
    }

    @PutMapping("/addAndAssignEquipeToDetailEquipeAndToProject/{idDetailEquipe}/{idProjet}")
    @ResponseBody
    public Equipe addAndAssignEquipeToDetailEquipeAndToProject(@RequestBody Equipe equipe,
        @PathVariable("idDetailEquipe") Integer idDetailEquipe,
        @PathVariable("idProjet")  Integer idProjet){
        return equipeServices.addAndAssignEquipeToDetailEquipeAndToProject(equipe, idDetailEquipe, idProjet);
    }
    @GetMapping("beneficeTotalOfEquipeBetweenTwoDate/{id}/{startDate}/{finDate}")
    @ResponseBody
    public float beneficeTotalOfEquipeByIdEquipeBetweenTwoDate(@PathVariable("id") Integer idEquipe,
        @PathVariable("startDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
        @PathVariable("finDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date finDate){
        return equipeServices.beneficeTotalOfEquipeByIdEquipeBetweenTwoDate(idEquipe,startDate,finDate);
    }

    @GetMapping("nbrEquipeWorkOnProjectHasOneOrMoreYear/{id}")
    @ResponseBody
    public Integer nbrEquipeWorkOnProjectHasOneOrMoreYear(@PathVariable("id")  Integer idEquipe) {
        return equipeServices.nbrEquipeWorkOnProjectHasOneOrMoreYear(idEquipe);
    }

    @PutMapping("/addParticipantToEquipeAndCheckNumberMax/{id}")
    @ResponseBody
    public void addParticipantToEquipeAndCheckNumberMax(@RequestBody  User u, @PathVariable("id")  Integer idEquipe) {
        equipeServices.addParticipantToEquipeAndCheckNumberMax(u,idEquipe);
    }

}



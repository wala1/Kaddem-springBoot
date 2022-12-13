package tn.esprit.kaddemspringbootproject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspringbootproject.entities.DetailEquipe;
import tn.esprit.kaddemspringbootproject.services.IDetailEquipeServices;
import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@Tag(name = "Detail Equipe Controller")
public class DetailEquipeRestController {
    @Autowired
    private final IDetailEquipeServices detailEquipeServices;

    @GetMapping("/DetailEquipe")
    @ResponseBody
    public List<DetailEquipe> retrieveAllDetailEquipe(){
        return detailEquipeServices.retrieveAllDetailEquipe();
    }

    @PostMapping("/addDetailEquipe")
    @ResponseBody
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe d){
        return detailEquipeServices.addDetailEquipe(d);
    }

    @PutMapping("/updateDetailEquipe/{id}")
    @ResponseBody
    public DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe detailEquipe,@PathVariable("id") Integer idDE){
        return detailEquipeServices.updateDetailEquipe(detailEquipe);
    }

    @DeleteMapping("removeDetailEquipe/{id}")
    @ResponseBody
    public void removeDetailEquipe(@PathVariable("id") Integer idDetailEquipe){
        detailEquipeServices.removeDetailEquipe(idDetailEquipe);
    }

    @GetMapping("retrieveDetailEquipe/{id}")
    @ResponseBody
    public void retrieveDetailEquipe(@PathVariable("id") Integer idDetailEquipe){
        detailEquipeServices.retrieveDetailEquipe(idDetailEquipe);
    }
    @DeleteMapping("removeAllDetailEquipe")
    public void removeAllDetailEquipe(){
        detailEquipeServices.removeAllDetailEquipe();
    }

    @GetMapping("getDetailEquipeByEquipeId/{id}")
    @ResponseBody
    public DetailEquipe getDetailEquipeByEquipeId(@PathVariable("id") Integer idEquipe) {
        return detailEquipeServices.getDetailEquipeByEquipeId(idEquipe);
    }
}

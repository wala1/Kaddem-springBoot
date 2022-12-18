package tn.esprit.kaddemspringbootproject.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspringbootproject.entities.Cours;
import tn.esprit.kaddemspringbootproject.entities.Universite;
import tn.esprit.kaddemspringbootproject.entities.categorieUniv;
import tn.esprit.kaddemspringbootproject.services.IUniversiteServices;

import javax.websocket.server.PathParam;
import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@Tag(name="Universities Management")
@RequestMapping("universite")
@RequiredArgsConstructor
public class UniversiteRestController {

    private final IUniversiteServices universiteServices;
    @Operation(description ="Retrive all universities")
    @GetMapping("/all")
    @ResponseBody
    public List<Universite> retrieveAllUniversite(){
        return universiteServices.retrieveAllUniversites();
    }
    @Operation(description ="Add University")
    @PostMapping("/add")
    @ResponseBody
    public Universite addUniversite(@RequestBody Universite u){
        return universiteServices.addUniversite(u);
    }
    @Operation(description ="Find university by id")
    @GetMapping("find/{id}")
    @ResponseBody
    public Universite findUniversite(@PathVariable("id") Integer idUniversite){
        return universiteServices.retrieveUniversite(idUniversite);
    }
    @Operation(description ="Affect university to department")
    @PutMapping("/affect/{idUniversite}/{idDepartement}")
    public void AffectUniversityToDepartment(@PathVariable("idUniversite") Integer idUniversite,@PathVariable("idDepartement") Integer idDepartement){
        universiteServices.assignUniversiteToDepartement(idUniversite,idDepartement);
    }
    @Operation(description = "update University")
    @PutMapping("/update")
    public void updateUniv(@RequestBody Universite univ){
        universiteServices.updateUniversite(univ);
    }
    @Operation(description = "delete")
    @DeleteMapping("/delete/{idUniv}")
    public void delete(@PathVariable("idUniv") Integer idUniv){
        universiteServices.removeUniv(idUniv);
    }
    @Operation(description ="Find universities by Categorie")
    @GetMapping("/findByCategorie/{cat}")
    @ResponseBody
    public List<Universite> findUniversiteByCat(@PathVariable("cat") categorieUniv categorieUniv){
        return universiteServices.findUnivByCategorie(categorieUniv);
    }
    @Operation(description = "Export List to pdf")
    @GetMapping("/export/pdf")
    public ResponseEntity<InputStreamResource> exportTermsPDF(){
        List<Universite> univ=retrieveAllUniversite();
        ByteArrayInputStream bais=universiteServices.univesritiesPDF(univ);
        HttpHeaders headers= new HttpHeaders();
        headers.add("Content-Disposition","inline; filename=universities.pdf");
        return  ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bais));
    }

}
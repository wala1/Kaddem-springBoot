package tn.esprit.kaddemspringbootproject.controllers;


import io.swagger.v3.oas.annotations.tags.Tag;
import javafx.scene.input.DataFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspringbootproject.entities.Projet;
import tn.esprit.kaddemspringbootproject.services.IProjetServices;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@Tag(name = "Projet Controller")
public class ProjetRestController {
    @Autowired
    private final IProjetServices projetServices;
    @Autowired
    ServletContext context;
    @GetMapping("/Projet")
    @ResponseBody
    public List<Projet> retrieveAllDetailProjet(){
        return projetServices.retrieveAllProjects();
    }

    @PostMapping("/addProjet")
    @ResponseBody
    public Projet addProjet(@RequestBody Projet projet){
        return projetServices.addProjet(projet);
    }
    @PutMapping("/updateProjet/{id}")
    @ResponseBody
    public Projet updateProjet(@RequestBody Projet projet,@PathVariable("id") Integer idProjet){
        return projetServices.updateProjet(projet,idProjet);
    }
    @GetMapping("Projet/{id}")
    @ResponseBody
    public void retrieveProjet(@PathVariable("id") Integer idProjet){
        projetServices.retrieveProjet(idProjet);
    }
    @DeleteMapping("removeProjet/{id}")
    @ResponseBody
    public void removeProjet(@PathVariable("id") Integer idProjet){
        projetServices.removeProjet(idProjet);
    }
    @DeleteMapping("removeAllProjet")
    @ResponseBody
    public void removeAllTache(){
        projetServices.removeAllProjet();
    }

    @GetMapping("exportProjet/pdf")
    public ResponseEntity<InputStreamResource> exportProjectsPdf(){
        List<Projet> projets = projetServices.retrieveAllProjects();
        ByteArrayInputStream bais = projetServices.projetsPDEFReport(projets);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition","inline; filename=projects.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bais));
    }

    @GetMapping("exportProjet/excel")
    public void exportProjectsExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Projects_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey,headerValue);

        List<Projet> listProjet = projetServices.retrieveAllProjects();
        ScategorieExcel excel = new ScategorieExcel(listProjet);
        excel.export(response);
    }


}

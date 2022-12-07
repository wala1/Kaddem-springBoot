package tn.esprit.kaddemspringbootproject.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspringbootproject.entities.Cours;
import tn.esprit.kaddemspringbootproject.entities.Universite;
import tn.esprit.kaddemspringbootproject.entities.categorieCours;
import tn.esprit.kaddemspringbootproject.entities.categorieUniv;
import tn.esprit.kaddemspringbootproject.services.ICourseServices;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name="Course Management")
@RequestMapping("cours")
public class CourseRestController {
    private final ICourseServices courseServices;
    @Operation(description="find all courses")
    @GetMapping("/all")
    @ResponseBody
    public List<Cours> findAllCourses(){
        return courseServices.retrieveAllCourses();
    }
    @Operation(description = "Add a course")
    @PostMapping("/add")
    @ResponseBody
    public Cours addTheCourse(@RequestBody  Cours c){
        return courseServices.addUCourse(c);
    }
    @Operation(description = "Update a course")
    @PutMapping("/update")
    @ResponseBody
    public  Cours updateTheCourse(@RequestBody  Cours c){
        return courseServices.addUCourse(c);
    }
    @Operation(description = "find a course by its ID")
    @GetMapping("/find/{idC}")
    @ResponseBody
    public  Cours findById(@PathVariable("idC") Integer idC){
        return courseServices.retrieveCourse(idC);
    }
    @Operation(description = "delete a course ")
    @DeleteMapping("/remove/{idC}")
    public void removeCourse(@PathVariable("idC") Integer idC){
        courseServices.removeCourse(idC);
    }
    @Operation(description ="Find Courses by Categorie")
    @GetMapping("/findByCategorie/{cat}")
    @ResponseBody
    public List<Cours> findCourseByCat(@PathVariable("cat") categorieCours cat){
        return courseServices.findCoursesByCateg(cat);
    }
    @Operation(description = "create course and affect univ")
    @PostMapping("/addCourseUniv/{nomUniv}")
    @ResponseBody
    public Cours addCourseUniv(@RequestBody Cours c, @PathVariable("nomUniv") String nomUniv){
        return  courseServices.createCousreAndAffectUniv(c,nomUniv);
    }
    @Operation(description = "find courses by universities")
    @GetMapping("/findCoursesByUniv/{idUniv}")
    @ResponseBody
    public  List<Cours> findCourssByUniversity(@PathVariable("idUniv") Integer idUniv){
        return courseServices.findCoursesByUuniv(idUniv);
    }



}

package tn.esprit.kaddemspringbootproject.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspringbootproject.entities.Cours;
import tn.esprit.kaddemspringbootproject.services.ICourseServices;

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



}

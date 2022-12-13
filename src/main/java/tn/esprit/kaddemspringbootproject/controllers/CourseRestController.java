package tn.esprit.kaddemspringbootproject.controllers;


import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspringbootproject.entities.*;
import tn.esprit.kaddemspringbootproject.services.ICourseServices;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name="Course Management")
@RequestMapping("cours")
public class CourseRestController {
    private final ICourseServices courseServices;
    public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "pay/cancel";

    @GetMapping("/test")
    public String home() {
        return "home";
    }
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
    @Operation(description = "find courses order by price asc")
    @GetMapping("/listAsc")
    public List<Cours> CoursOrderByPriceASC(){
        return courseServices.CoursOrderByPriceASC();
    }
    @Operation(description = "find courses order by price Desc")
    @GetMapping("/listADesc")
    public List<Cours> CoursOrderByPriceDESC(){
        return courseServices.CoursOrderByPriceDESC();
    }
    @PostMapping("/pay")
    @ResponseBody
    public String payment(@RequestBody Order order) {
        try {
            Payment payment = courseServices.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
                    order.getIntent(), order.getDescription(), "http://localhost:8085/Kaddem/cours/" + CANCEL_URL,
                    "http://localhost:8085/Kaddem/cours/" + SUCCESS_URL);
            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    return "redirect:"+link.getHref();
                }
            }

        } catch (PayPalRESTException e) {

            e.printStackTrace();
        }
        return "erreur"; //"redirect:/test";
    }

    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "cancel";
    }

    @GetMapping(value = SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = courseServices.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return "success";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/test";
    }




}

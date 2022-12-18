package tn.esprit.kaddemspringbootproject.services;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import tn.esprit.kaddemspringbootproject.entities.Cours;
import tn.esprit.kaddemspringbootproject.entities.categorieCours;

import java.util.List;

public interface ICourseServices {
    List<Cours> retrieveAllCourses();
    Cours addUCourse (Cours u);
    Cours updateCourse (Cours u);
    Cours retrieveCourse (Integer idCours);
    void removeCourse(Integer idCours);
    List<Cours> findCoursesByCateg(categorieCours cat);
    Cours createCousreAndAffectUniv(Cours s, String nom);
    List<Cours>  findCoursesByUuniv(Integer idUniv);
    //Payment createPayment(Double total, String currency, String method, String intent, String description, String cancelUrl, String successUrl) throws PayPalRESTException;
    //Payment executePayment(String paymentId, String payerId) throws PayPalRESTException;
    List<Cours> CoursOrderByPriceASC();
    List<Cours> CoursOrderByPriceDESC();

}
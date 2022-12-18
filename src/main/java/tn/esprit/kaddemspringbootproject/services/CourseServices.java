package tn.esprit.kaddemspringbootproject.services;


import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspringbootproject.entities.Cours;
import tn.esprit.kaddemspringbootproject.entities.Universite;
import tn.esprit.kaddemspringbootproject.entities.categorieCours;
import tn.esprit.kaddemspringbootproject.repositories.ICoursRepository;
import tn.esprit.kaddemspringbootproject.repositories.IUniversiteRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServices implements ICourseServices {
    private final ICoursRepository coursRepository;
    private final IUniversiteRepository universiteRepository;
    //private final APIContext apiContext;
    @Override
    public List<Cours> retrieveAllCourses() {
        return coursRepository.findAll();
    }

    @Override
    public Cours addUCourse(Cours u) {
        return  coursRepository.save(u);
    }

    @Override
    public Cours updateCourse(Cours u) {
        return coursRepository.save(u);
    }

    @Override
    public Cours retrieveCourse(Integer idCours) {
        return coursRepository.findById(idCours).orElse(null);
    }

    @Override
    public void removeCourse(Integer idCours) {
        coursRepository.deleteById(idCours);
    }

    @Override
    public List<Cours> findCoursesByCateg(categorieCours cat) {
        return coursRepository.findByCategorieCours(cat);
    }

    @Override
    public Cours createCousreAndAffectUniv(Cours s, String nom) {
        Universite u =universiteRepository.findByNomUniv(nom);
        s.setUniversite(u);
        return coursRepository.save(s);
    }

    @Override
    public List<Cours> findCoursesByUuniv(Integer idUniv) {
        return coursRepository.findByUniversite_IdUniv(idUniv);
    }

   /* @Override
    public Payment createPayment(Double total, String currency, String method, String intent, String description, String cancelUrl, String successUrl)  throws PayPalRESTException {
        Amount amount = new Amount();
        amount.setCurrency(currency);
        total = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
        amount.setTotal(String.format("%.2f", total));

        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod(method.toString());

        Payment payment = new Payment();
        payment.setIntent(intent.toString());
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(cancelUrl);
        redirectUrls.setReturnUrl(successUrl);
        payment.setRedirectUrls(redirectUrls);

        return payment.create(apiContext);
    }


    @Override
    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException{
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);
        return payment.execute(apiContext, paymentExecute);
    }*/

    @Override
    public List<Cours> CoursOrderByPriceASC() {
        return coursRepository.CoursOrderByPriceASC();
    }

    @Override
    public List<Cours> CoursOrderByPriceDESC() {
        return coursRepository.CoursOrderByPriceDESC();
    }
}
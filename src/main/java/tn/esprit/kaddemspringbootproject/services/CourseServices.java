package tn.esprit.kaddemspringbootproject.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspringbootproject.entities.Cours;
import tn.esprit.kaddemspringbootproject.entities.Universite;
import tn.esprit.kaddemspringbootproject.entities.categorieCours;
import tn.esprit.kaddemspringbootproject.repositories.ICoursRepository;
import tn.esprit.kaddemspringbootproject.repositories.IUniversiteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServices implements ICourseServices {
    private final ICoursRepository coursRepository;
    private final IUniversiteRepository universiteRepository;
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
}

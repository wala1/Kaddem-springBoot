package tn.esprit.kaddemspringbootproject.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddemspringbootproject.entities.Cours;
import tn.esprit.kaddemspringbootproject.repositories.ICoursRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServices implements ICourseServices {
    private final ICoursRepository coursRepository;
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
}

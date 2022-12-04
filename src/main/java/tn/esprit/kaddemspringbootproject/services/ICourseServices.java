package tn.esprit.kaddemspringbootproject.services;

import tn.esprit.kaddemspringbootproject.entities.Cours;

import java.util.List;

public interface ICourseServices {
    List<Cours> retrieveAllCourses();
    Cours addUCourse (Cours u);
    Cours updateCourse (Cours u);
    Cours retrieveCourse (Integer idCours);
    void removeCourse(Integer idCours);
}

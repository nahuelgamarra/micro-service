package demo.school.service;

import demo.school.model.FullSchoolResponse;
import demo.school.model.School;

import java.util.List;

public interface SchoolService {
    void saveSchool(School school);
    List<School> findAllSchool();

    FullSchoolResponse findSchoolWithStudent(Long id);
}

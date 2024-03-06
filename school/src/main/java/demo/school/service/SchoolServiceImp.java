package demo.school.service;

import demo.school.client.StudentClient;
import demo.school.model.FullSchoolResponse;
import demo.school.model.School;
import demo.school.model.Student;
import demo.school.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImp implements SchoolService {
    private final SchoolRepository schoolRepository;
    private StudentClient studentClient;
    @Autowired
    public SchoolServiceImp(SchoolRepository schoolRepository, StudentClient studentClient) {
        this.schoolRepository = schoolRepository;
        this.studentClient = studentClient;
    }


    public void saveSchool(School school){
        schoolRepository.save(school);
    }

    public List<School> findAllSchool(){
        return schoolRepository.findAll();
    }

    @Override
    public FullSchoolResponse findSchoolWithStudent(Long schoolId) {
     School schoolSearched= schoolRepository.findById(schoolId)
                .orElse(School.builder()
                        .name("Not_Found")
                        .email("Not_found")
                        .build());
        List<Student> studentSearched= studentClient.findAllStudentBySchool(schoolId);

        return FullSchoolResponse.builder()
                .name(schoolSearched.getName())
                .email(schoolSearched.getEmail())
                .students(studentSearched).build();

    }
}



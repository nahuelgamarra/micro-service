package demo.student.service;

import demo.student.model.Student;
import demo.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public void savedStudent(Student student){
        studentRepository.save(student);
    }
    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAllStudentBySchool(Long schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }

}

package demo.student.service;

import demo.student.model.Student;

import java.util.List;

public interface StudentService {
    void savedStudent(Student student);
    List<Student> findAllStudent();

    List<Student> findAllStudentBySchool(Long schoolId);
}

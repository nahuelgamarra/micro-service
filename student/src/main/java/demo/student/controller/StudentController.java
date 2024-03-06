package demo.student.controller;

import demo.student.model.Student;
import demo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Student student) {
        studentService.savedStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudent() {
        return new ResponseEntity<>(studentService.findAllStudent(), HttpStatus.OK);
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findAllStudentBySchool(@PathVariable("school-id") Long schoolId){
        return  new ResponseEntity<>(studentService.findAllStudentBySchool(schoolId),HttpStatus.OK);
    }


}

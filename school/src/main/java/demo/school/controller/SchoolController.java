package demo.school.controller;

import demo.school.model.FullSchoolResponse;
import demo.school.model.School;
import demo.school.service.SchoolService;
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
@RequestMapping("/api/v1/school")
public class SchoolController {

    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSchool(@RequestBody School school){
        schoolService.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchool(){
        return new ResponseEntity<>(schoolService.findAllSchool(),HttpStatus.OK);
    }
    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findSchoolWithStudent(@PathVariable("school-id") Long id){
        return new ResponseEntity<>(schoolService.findSchoolWithStudent(id), HttpStatus.OK);
    }
}

package com.example3.database2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return new ResponseEntity("Student saved to the database", HttpStatus.CREATED);

    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    @GetMapping("/between")
    public List<Student> getStudentsAgeBetween(@RequestParam Integer age1,
                                               @RequestParam Integer age2) {
        return studentRepository.findStudentByAgeBetween(age1,age2);
    }

    @PutMapping("/students/updateByName")
    public String updateStudentsByName(
            @RequestParam String oldName,
            @RequestParam String newName) {
        int updatedCount = studentRepository.updateStudentsByName(oldName, newName);
        return "Updated " + updatedCount + " student(s) with name " + oldName + " to " + newName;
    }

    @DeleteMapping("students/deleteByAge")
    public String deleteStudentsByAge(@RequestParam Integer age) {
        int deletedCount = studentRepository.deleteStudentsByAge(age);
        return "Deleted " + deletedCount + " student(s) with age " + age;
    }
}







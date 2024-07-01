package com.accelerate.demo.student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/students")
    public StudentResponseDto saveStudent(@RequestBody StudentDto dto) {
        return this.studentService.saveStudent(dto);
    }

    @GetMapping(value = "/students")
    public List<StudentResponseDto> findAllStudent() {
        return studentService.findAllStudent();
    }

    @GetMapping(value = "/students/{id}")
    public StudentResponseDto findStudentById(@PathVariable Integer id) {
        return studentService.findStudentById(id);
    }

    @GetMapping(value = "/students/search/{student-name}")
    public List<StudentResponseDto> findStudentByFirstName(@PathVariable("student-name") String name) {
        return studentService.findStudentByName(name);
    }


    @DeleteMapping(value = "/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(@PathVariable Integer id) {
        studentService.delete(id);
    }

}
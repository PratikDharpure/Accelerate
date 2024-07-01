package com.accelerate.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentController(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    @PostMapping(value = "/students")
    public StudentResponseDto post(@RequestBody StudentDto dto) {
        var student = studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    @GetMapping(value = "/students")
    public List<Student> findAllStudent() {
        return repository.findAll();
    }

    @GetMapping(value = "/students/{id}")
    public Student findStudentById(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping(value = "/students/search/{student-name}")
    public List<Student> findStudentByFirstName(@PathVariable("student-name") String firstName) {
        return repository.findAllByFirstNameContaining(firstName);
    }

    @DeleteMapping(value = "/students")
    public void deleteAllStudent() {
        repository.deleteAll();
    }

    @DeleteMapping(value = "/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}
package com.accelerate.demo;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentRepository getRepository() {
        return repository;
    }

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

}

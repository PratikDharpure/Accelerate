package com.accelerate.demo.school;

import java.util.List;
import java.util.stream.Collectors;

public class SchoolService {

    private final SchoolMapper schoolMapper;
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolMapper schoolMapper, SchoolRepository schoolRepository) {
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
    }

    public SchoolDto create(
            SchoolDto dto) {
        var school = schoolMapper.toSchool(dto);
        schoolRepository.save(school);
        return dto;
    }

    public List<SchoolDto> findAll() {

        return schoolRepository
                .findAll()
                .stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList());
    }
}

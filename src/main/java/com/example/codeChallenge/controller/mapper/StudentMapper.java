package com.example.codeChallenge.controller.mapper;

import com.example.codeChallenge.model.dto.StudentDTO;
import com.example.codeChallenge.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "code", target = "code")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "age", target = "age")
    Student studentDTOToStudent (StudentDTO studentDTO);
}

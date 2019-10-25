package com.switchfully.rest.funiversity.api;

import com.switchfully.rest.funiversity.domain.Professor;
import com.switchfully.rest.funiversity.api.dtos.RequestProfessorDto;
import com.switchfully.rest.funiversity.api.dtos.ResponseProfessorDto;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public Professor mapToDomain(RequestProfessorDto dto) {
        return new Professor(
                dto.getFirstname(),
                dto.getLastname());
    }

    public ResponseProfessorDto mapToDto(Professor professor) {
        return new ResponseProfessorDto()
                .setId(professor.getId())
                .setFirstname(professor.getFirstname())
                .setLastname(professor.getLastname());
    }

}

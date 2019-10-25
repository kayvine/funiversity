package com.switchfully.rest.funiversity.webapi;

import com.switchfully.rest.funiversity.domain.Professor;
import com.switchfully.rest.funiversity.webapi.dtos.RequestProfessorDto;
import com.switchfully.rest.funiversity.webapi.dtos.ProfessorDto;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public Professor mapToDomain(RequestProfessorDto dto) {
        return new Professor(
                dto.getFirstname(),
                dto.getLastname());
    }

    public ProfessorDto mapToDto(Professor professor) {
        return new ProfessorDto()
                .setId(professor.getId())
                .setFirstname(professor.getFirstname())
                .setLastname(professor.getLastname());
    }

}

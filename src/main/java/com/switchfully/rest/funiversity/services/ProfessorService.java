package com.switchfully.rest.funiversity.services;

import com.switchfully.rest.funiversity.domain.Professor;
import com.switchfully.rest.funiversity.domain.ProfessorRepository;
import com.switchfully.rest.funiversity.webapi.ProfessorMapper;
import com.switchfully.rest.funiversity.webapi.dtos.RequestProfessorDto;
import com.switchfully.rest.funiversity.webapi.dtos.ProfessorDto;
import com.switchfully.rest.funiversity.webapi.exceptionclasses.ProfessorAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ProfessorService {

    private ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor getProfessorById(String id) {
        return professorRepository.getById(id);
    }

    public Collection<Professor> getAllProfessors() {
        return professorRepository.getAll();
    }

    public Professor createNewProfessor(RequestProfessorDto createProfessorDto) {
        Professor newProfessor = new Professor(createProfessorDto.getFirstname(), createProfessorDto.getLastname());
        if (professorRepository.professorAlreadyExists(newProfessor)) {
            throw new ProfessorAlreadyExistsException("The provided name is not unique");
        }
        return professorRepository.save(newProfessor);
    }

    public Professor updateProfessor(String id, RequestProfessorDto updateProfessorDto) {
        Professor tempProfessor = professorRepository.getById(id);
        tempProfessor.update(updateProfessorDto); // update returns void
        return tempProfessor;
    }

    public void deleteProfessor(String id) {
        professorRepository.delete(id);
    }

}

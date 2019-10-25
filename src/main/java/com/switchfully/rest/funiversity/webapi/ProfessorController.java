package com.switchfully.rest.funiversity.webapi;

import com.switchfully.rest.funiversity.services.ProfessorService;
import com.switchfully.rest.funiversity.webapi.dtos.RequestProfessorDto;
import com.switchfully.rest.funiversity.webapi.dtos.ProfessorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(ProfessorController.PROFESSOR_CONTROLLER_RESOURCE_URI)
public class ProfessorController {

    public static final String PROFESSOR_CONTROLLER_RESOURCE_URI = "/professors";

    private final Logger logger = LoggerFactory.getLogger(ProfessorController.class);

    private final ProfessorService professorService;
    private final ProfessorMapper professorMapper;

    @Autowired
    public ProfessorController(ProfessorService professorService, ProfessorMapper professorMapper) {
        this.professorService = professorService;
        this.professorMapper = professorMapper;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ProfessorDto> getAll() {
        logger.info("Handler method getAll() is called");
        return professorService.getAllProfessors().stream()
                .map(professorMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDto getProfessor(@PathVariable(value = "id") String id) {
        return professorMapper.mapToDto(
                professorService.getProfessorById(id)
        );
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorDto createProfessor(@RequestBody RequestProfessorDto createProfessorDto) {
        logger.info("Creating new professor ...");
        return professorMapper.mapToDto(
                professorService.createNewProfessor(createProfessorDto)
        );
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProfessorDto updateProfessor(@PathVariable String id, @RequestBody RequestProfessorDto updateProfessorDto) {
        logger.info("Updating professor ...");
        return professorMapper.mapToDto(
                professorService.updateProfessor(id, updateProfessorDto)
        );
    }

    @DeleteMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteProfessor(@PathVariable String id) {
        logger.info("Deleting professor ...");
        professorService.deleteProfessor(id);
    }

}

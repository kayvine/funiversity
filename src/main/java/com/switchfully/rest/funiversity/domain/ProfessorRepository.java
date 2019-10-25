package com.switchfully.rest.funiversity.domain;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Just a dummy - in memory - repository
 * Management Bean by Spring (will be found by component scanning)
 */
@Component
public class ProfessorRepository {

    private final ConcurrentHashMap<String, Professor> professorsById;

    public ProfessorRepository() {
        Professor professor1 = new Professor("Arnold", "Bob");
        Professor professor2 = new Professor("Sean", "Bean");
        Professor professor3 = new Professor("Tom", "Sawyer");

        this.professorsById = new ConcurrentHashMap<>(
                Map.of(
                        professor1.getId(), professor1,
                        professor2.getId(), professor2,
                        professor3.getId(), professor3
                )
        );
    }

    public Professor save(Professor professor) {
        professorsById.put(professor.getId(), professor);
        return professor;
    }

    /**
     * Finds the {@code Professor} object for the provided {@code id}
     *
     * @param id the id of the {@code Professor} to find
     * @return the {@code Professor} object for the specified {@code id}
     * @throws RuntimeException if no {@code Professor} object was found for the specified {@code id}
     */
    public Professor getById(String id) throws RuntimeException {
        var foundProfessor = professorsById.get(id);
        if (foundProfessor == null) {
            throw new RuntimeException("No Professor could be found for id " + id);
        }
        return foundProfessor;
    }

    public Collection<Professor> getAll() {
        return professorsById.values();
    }

    public boolean professorAlreadyExists(Professor professor) {
        return professorsById.containsValue(professor);
    }

    public void delete(String id) {
        professorsById.remove(id);
    }
}

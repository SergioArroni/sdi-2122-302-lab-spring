package com.example.sdi212202spring.service;

import com.example.sdi212202spring.entities.Professor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProfessorService {

    private List<Professor> professorList = new LinkedList<>();

    @PostConstruct
    public void init() {
        professorList.add(new Professor(1L, "000000A", "Juan", "Cueva", "Malvado"));
        professorList.add(new Professor(2L, "000000B", "Dario", "Alvarez", "Graciosillo"));
        professorList.add(new Professor(3L, "000000C", "Cristina", "Pelayo", "Exigente"));
    }

    public List<Professor> getProfessor() {
        return professorList;
    }

    public Professor getProfessor(Long id) {
        return professorList.stream().filter(professor -> professor.getId().equals(id)).findFirst().get();
    }

    public void addProfessor(Professor Professor) {
        if (Professor.getId() == null) {
            Professor.setId(professorList.get(professorList.size() - 1).getId() + 1);
        }
        professorList.add(Professor);
    }

    public void editProfessor(Professor Professor) {
        if (Professor.getId() != null) {
            deleteProfessor(Professor.getId());
            addProfessor(Professor);
        }

    }

    public void deleteProfessor(Long id) {
        professorList.removeIf(professor -> professor.getId().equals(id));
    }
}
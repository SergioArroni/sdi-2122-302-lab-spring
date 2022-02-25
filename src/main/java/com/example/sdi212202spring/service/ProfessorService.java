package com.example.sdi212202spring.service;

import com.example.sdi212202spring.entities.Professor;
import com.example.sdi212202spring.entities.User;
import com.example.sdi212202spring.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> getProfessor() {
        List<Professor> professors = new ArrayList<Professor>();
        professorRepository.findAll().forEach(professors::add);
        return professors;
    }

    public Professor getProfessor(Long id) {
        return professorRepository.findById(id).get();
    }

    public void addProfessor(Professor professor) { // Si en Id es null le asignamos el último + 1 de la lista
        professorRepository.save(professor);
    }

    public void editProfessor(Professor Professor) {
        if(professorRepository.existsById(Professor.getId())){
            professorRepository.save(Professor);
        }

    }

    public void deleteProfessor(Long id) {
        professorRepository.deleteById(id);
    }

    public Professor getProfessorByDni(String dni) {
        return professorRepository.findByDni(dni);
    }
}
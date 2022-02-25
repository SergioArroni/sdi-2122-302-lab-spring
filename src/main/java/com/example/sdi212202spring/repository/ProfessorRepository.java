package com.example.sdi212202spring.repository;

import com.example.sdi212202spring.entities.Mark;
import com.example.sdi212202spring.entities.Professor;
import com.example.sdi212202spring.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {
    Professor findByDni(String dni);
}

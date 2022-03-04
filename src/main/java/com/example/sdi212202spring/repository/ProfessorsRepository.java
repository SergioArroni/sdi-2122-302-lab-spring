package com.example.sdi212202spring.repository;

import com.example.sdi212202spring.entities.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorsRepository extends CrudRepository<Professor, Long>{

    Professor findByDni(String dni);

}

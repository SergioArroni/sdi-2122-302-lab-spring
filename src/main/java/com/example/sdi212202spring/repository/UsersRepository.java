package com.example.sdi212202spring.repository;

import com.example.sdi212202spring.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
    User findByDni(String dni);
}

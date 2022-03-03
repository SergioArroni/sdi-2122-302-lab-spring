package com.example.sdi212202spring.repository;

import com.example.sdi212202spring.entities.Mark;
import com.example.sdi212202spring.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MarksRepository extends CrudRepository<Mark, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Mark SET resend = ?1 WHERE id = ?2")
    void updateResend(Boolean resend, Long id);
    @Query("SELECT r FROM Mark r WHERE r.user = ?1 ORDER BY r.id ASC")
    Page<Mark> findAllByUser(Pageable pageable, User user);

    @Query("select r from Mark r where (LOWER(r.description) LIKE LOWER(?1) OR LOWER(r.user.name) LIKE lower(?1))")
    Page<Mark> searchByDescriptionAndName (Pageable pageable, String searchText);

    Page<Mark> findAll(Pageable pageable);

    @Query("select r from Mark r where (LOWER(r.description) LIKE LOWER(?1) OR LOWER(r.user.name) LIKE lower(?1)) AND r.user=?2")
    Page<Mark> searchByDescriptionNameAndUser (Pageable pageable, String searchText, User user);
}

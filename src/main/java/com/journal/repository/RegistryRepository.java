package com.journal.repository;

import com.journal.data.entities.Registry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RegistryRepository extends JpaRepository<Registry, Long> {

    List<Registry> findAllByDateOfLesson(LocalDate date);
}
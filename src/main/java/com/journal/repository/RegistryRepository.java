package com.journal.repository;

import com.journal.data.entities.Registry;
import com.journal.data.entities.Subject;
import com.journal.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RegistryRepository extends JpaRepository<Registry, Long> {

    List<Registry> findAllByDateOfLesson(LocalDate date);

    boolean existsByDateOfLessonAndSubject(LocalDate date, Subject subject);

    List<Registry> findAllByDateOfLessonBetweenAndUser(LocalDate from, LocalDate to, User user);

    @Modifying
    @Query("DELETE FROM Registry WHERE subject = :subject AND dateOfLesson = :date")
    void deleteAllBySubjectAndDateOfLesson(@Param("subject") Subject subject, @Param("date") LocalDate date);
}
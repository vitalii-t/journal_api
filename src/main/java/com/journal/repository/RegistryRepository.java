package com.journal.repository;

import com.journal.data.entities.Registry;
import com.journal.data.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistryRepository extends JpaRepository<Registry, Long> {
//    void saveRegistry();
}
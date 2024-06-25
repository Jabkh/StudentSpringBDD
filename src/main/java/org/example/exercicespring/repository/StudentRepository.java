package org.example.exercicespring.repository;

import org.example.exercicespring.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    List<Student> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
}

package org.example.exercicespring.service;

import org.example.exercicespring.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    private final Map<UUID, Student> students = new HashMap<>();

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public Student getStudentById(UUID id) {
        return students.get(id);
    }

    public Student saveStudent(Student student) {
        student.setId(UUID.randomUUID());
        students.put(student.getId(), student);
        return student;
    }

    public Student updateStudent(UUID id, Student student) {
        students.put(id, student);
        return student;
    }

    public void deleteStudent(UUID id) {
        students.remove(id);
    }

    public List<Student> getByName(String name) {
        return students.values().stream()
                .filter(student -> student.getFirstName().toLowerCase().contains(name.toLowerCase()) ||
                        student.getLastName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    public List<Student> getByFirstName(String firstName) {
        return students.values().stream()
                .filter(student -> student.getFirstName().toLowerCase().contains(firstName.toLowerCase()))
                .toList();
    }
}

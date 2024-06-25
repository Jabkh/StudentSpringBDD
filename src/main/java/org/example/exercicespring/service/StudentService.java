package org.example.exercicespring.service;

import org.example.exercicespring.model.Student;
import org.example.exercicespring.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(UUID id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(UUID id, Student updatedStudent) {
        if (studentRepository.existsById(id)) {
            updatedStudent.setId(id);
            studentRepository.save(updatedStudent);
        }
    }

    public void deleteStudent(UUID id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getByName(String query) {
        return studentRepository.findByFirstNameContainingOrLastNameContaining(query, query);
    }
}

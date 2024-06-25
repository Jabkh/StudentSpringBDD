package org.example.exercicespring.controller;

import org.example.exercicespring.model.Student;
import org.example.exercicespring.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String list(Model model){
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/{studentId}")
    public String detailPage(@PathVariable("studentId") String studentId, Model model){
        try {
            UUID id = UUID.fromString(studentId);
            Student student = studentService.getStudentById(id);
            if (student != null) {
                model.addAttribute("student", student);
                return "student_detail";
            }
            return "redirect:/students";
        } catch (IllegalArgumentException e) {
            // Handle invalid UUID format error
            return "redirect:/students";
        }
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student_form";
    }


    @PostMapping
    public String createStudent(@ModelAttribute Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{studentId}")
    public String showEditForm(@PathVariable("studentId") UUID studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "student_form";
        }
        return "redirect:/students";
    }

    @PutMapping("/update/{studentId}")
    public String updateStudent(@PathVariable("studentId") UUID studentId, @ModelAttribute Student student){
        studentService.updateStudent(studentId, student);
        return "redirect:/students";
    }

    @PostMapping("/delete/{studentId}")
    public String deleteStudent(@PathVariable("studentId") UUID studentId){
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }

    @GetMapping("/search")
    public String showSearchForm() {
        return "search";
    }

    @PostMapping("/search")
    public String searchStudent(@RequestParam("query") String query, Model model){
        List<Student> students = studentService.getByFirstName(query);
        model.addAttribute("students", students);
        return "search_results";
    }
}
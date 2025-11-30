package com.Spring.SpringBootWithJSP.Controller;


import com.Spring.SpringBootWithJSP.Model.Student;
import com.Spring.SpringBootWithJSP.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAllStudents")
    public String findAll(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "Students";
    }

    @GetMapping("/addStudentForm")
    public String showAddStudentForm() {
        return "addStudentForm";
    }
    @PostMapping("/addStudent")
    public String add(Student student) {
        studentService.add(student);
        return "redirect:/getAllStudents";
    }
    @GetMapping("/getByIDStudent")
    public String findByID(@RequestParam Long id, Model model) {
        Student student = studentService.findByID(id);
        if(student == null) {
            model.addAttribute("errorMessage", "Student not found with ID: " + id);
            return "getByIDStudent";
        }
        model.addAttribute("student", student);
        return "getByIDStudent";
    }
    @PutMapping("updateStudent")
    public String update(Student student) {
        studentService.update(student);
        return "redirect:/getAllStudents";
    }
}

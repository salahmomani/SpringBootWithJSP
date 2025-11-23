package com.Spring.SpringBootWithJSP.Controller;


import com.Spring.SpringBootWithJSP.Model.Student;
import com.Spring.SpringBootWithJSP.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAllStudents")
    public String findAll() {
        studentService.findAll();
        return "Students";
    }
    @GetMapping("/addStudentForm")
    public String showAddStudentForm() {
        return "addStudentForm";
    }
    @PostMapping("/addStudent")
    public String add(Student student) {
        studentService.add(student);
        return "addStudent";
    }

    @GetMapping("/getByIDStudent")
    public String findByID(@RequestParam Long id) {
        studentService.findByID(id);
        return "getByIDStudent";
    }

    @PutMapping("updateStudent")
    public String update(Student student) {
        studentService.update(student);
        return "updateStudent";
    }
}

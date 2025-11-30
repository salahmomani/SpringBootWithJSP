package com.Spring.SpringBootWithJSP.Controller;

import com.Spring.SpringBootWithJSP.Model.Student;
import com.Spring.SpringBootWithJSP.Model.Teacher;
import com.Spring.SpringBootWithJSP.Service.StudentService;
import com.Spring.SpringBootWithJSP.Service.TeacherService;
import org.apache.tomcat.util.http.parser.TE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TeacherController {

    private final TeacherService teacherService;


    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/getAllTeachers")
    public String findAll(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        return "Teachers";
    }

    @PostMapping("/addTeacher")
    public String add(Teacher teacher) {
        teacherService.add(teacher);
        return "redirect:/getAllTeachers";
    }

    @GetMapping("/getByIDTeacher")
    public String findByID(@RequestParam Long id, Model model) {
        Teacher teacher = teacherService.findByID(id);
        model.addAttribute("teacher", teacher);
        return "getByIDTeacher";
    }

    @PutMapping("updateTeacher")
    public String update(Teacher teacher) {
        teacherService.update(teacher);
        return "redirect:/getAllTeachers";
    }
    @GetMapping("/addTeacherForm")
    public String showAddTeacherForm() {
        return "addTeacherForm";
    }
}

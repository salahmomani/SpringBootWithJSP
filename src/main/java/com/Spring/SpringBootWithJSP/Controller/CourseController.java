package com.Spring.SpringBootWithJSP.Controller;

import com.Spring.SpringBootWithJSP.Model.Course;
import com.Spring.SpringBootWithJSP.Repo.RepoCourse;
import com.Spring.SpringBootWithJSP.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/addCourse")
    public String add(Course course) {
        courseService.add(course);
        return "addCourse";
    }

    @GetMapping("/courses")
    public String findAll() {
        courseService.findAll();
        return "courses file";
    }
}

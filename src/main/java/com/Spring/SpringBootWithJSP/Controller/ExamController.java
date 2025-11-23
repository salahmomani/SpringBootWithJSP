package com.Spring.SpringBootWithJSP.Controller;

import com.Spring.SpringBootWithJSP.Model.Exam;
import com.Spring.SpringBootWithJSP.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExamController {

    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/addExamForm")
    public String showAddExamForm() {
        return "addExamForm";
    }

    @PostMapping("/addExam")
    public String add(Exam exam) {
        examService.add(exam);
        return "examAdded";
    }

    @GetMapping("/getScores")
    public String getScores(Long id) {
        return "scoresList";
    }
}

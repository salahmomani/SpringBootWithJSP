package com.Spring.SpringBootWithJSP.Controller;

import com.Spring.SpringBootWithJSP.Model.Exam;
import com.Spring.SpringBootWithJSP.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/exam")
public class ExamController {

    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("exam", new Exam());
        return "addExamForm";
    }

    @PostMapping("/add")
    public String addExam(@ModelAttribute Exam exam) {
        examService.add(exam);
        return "redirect:/exam/all";
    }

    @GetMapping("/all")
    public String getAllExams(Model model) {
        model.addAttribute("exams", examService.getAll());
        return "listExams";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam Long id, Model model) {
        model.addAttribute("exam", examService.getById(id));
        return "editExamForm";
    }

    @PostMapping("/edit")
    public String editExam(@ModelAttribute Exam exam) {
        examService.update(exam);
        return "redirect:/exam/all";
    }

    @GetMapping("/delete")
    public String deleteExam(@RequestParam Long id) {
        examService.delete(id);
        return "redirect:/exam/all";
    }
}

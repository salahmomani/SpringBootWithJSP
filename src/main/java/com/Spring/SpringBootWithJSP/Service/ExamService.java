package com.Spring.SpringBootWithJSP.Service;

import com.Spring.SpringBootWithJSP.Model.Exam;
import com.Spring.SpringBootWithJSP.Repo.RepoExam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {
    private final RepoExam repoExam;

    @Autowired
    public ExamService(RepoExam repoExam) {
        this.repoExam = repoExam;
    }

    public void add(Exam exam) {
        repoExam.addExam(exam);
    }

    public List<Exam> listScoresForStudent(Long id) {
        return repoExam.listScoresForStudent(id);
    }
}

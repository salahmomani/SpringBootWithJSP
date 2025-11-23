package com.Spring.SpringBootWithJSP.Repo;

import com.Spring.SpringBootWithJSP.Model.Exam;
import com.Spring.SpringBootWithJSP.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepoExam {

    List<Exam> exams = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;
    String addQuery = "INSERT INTO exams(course_id,name,max_score) VALUES(?,?,?)";
    String getAllQuery = "SELECT sc.id,\n" +
            "             s.name  AS student,\n" +
            "             s.email AS email,\n" +
            "             c.code  AS course,\n" +
            "             e.name  AS exam,\n" +
            "             e.max_score AS max_score,\n" +
            "             sc.score\n" +
            "      FROM scores sc\n" +
            "      JOIN exams   e ON e.id = sc.exam_id\n" +
            "      JOIN students s ON s.id = sc.student_id\n" +
            "      JOIN courses  c ON c.id = e.course_id\n" +
            "      WHERE sc.student_id = ?\n";

    @Autowired
    public RepoExam(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addExam(Exam exam) {
        int rows = jdbcTemplate.update(addQuery, exam.getCourseId(), exam.getName(), exam.getMaxScore());
        System.out.println(rows + " Added");
    }

    public Student student;

    public List<Exam> listScoresForStudent(Long id) {
        RowMapper<Exam> mapper = (rs, rowNum) -> {
            Exam exam = new Exam();
            exam.setId(rs.getLong("ID"));
            exam.setName(rs.getString("Name"));
            exam.setCourseId(rs.getLong("CourseID"));
            exam.setMaxScore(rs.getByte("MaxScore"));
            return exam;

        };
        return jdbcTemplate.query(getAllQuery, mapper);

    }
}
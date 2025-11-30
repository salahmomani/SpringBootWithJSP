package com.Spring.SpringBootWithJSP.Repo;

import com.Spring.SpringBootWithJSP.Model.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepoExam {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RepoExam(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Exam> examMapper = (rs, rowNum) -> {
        Exam exam = new Exam();
        exam.setId(rs.getLong("id"));
        exam.setCourseId(rs.getLong("course_id"));
        exam.setName(rs.getString("name"));
        exam.setMaxScore(rs.getInt("max_score"));
        return exam;
    };

    private static final String INSERT = "INSERT INTO exams(course_id, name, max_score) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM exams";
    private static final String SELECT_BY_ID = "SELECT * FROM exams WHERE id = ?";
    private static final String UPDATE = "UPDATE exams SET course_id=?, name=?, max_score=? WHERE id=?";
    private static final String DELETE = "DELETE FROM exams WHERE id=?";

    public void addExam(Exam exam) {
        jdbcTemplate.update(INSERT, exam.getCourseId(), exam.getName(), exam.getMaxScore());
    }

    public List<Exam> getAllExams() {
        return jdbcTemplate.query(SELECT_ALL, examMapper);
    }

    public Exam getById(Long id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, examMapper, id);
    }

    public void update(Exam exam) {
        jdbcTemplate.update(UPDATE, exam.getCourseId(), exam.getName(), exam.getMaxScore(), exam.getId());
    }

    public void delete(Long id) {
        jdbcTemplate.update(DELETE, id);
    }
}

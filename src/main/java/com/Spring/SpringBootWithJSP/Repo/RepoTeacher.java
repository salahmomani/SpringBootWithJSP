package com.Spring.SpringBootWithJSP.Repo;

import com.Spring.SpringBootWithJSP.Model.Student;
import com.Spring.SpringBootWithJSP.Model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepoTeacher {

    List<Teacher> Teachers = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;
    String getAllQuery = "select * from students ";
    String addQuery = "INSERT INTO students(name,email) VALUES(?,?)";
    String getByID = "select * from teacher where id=?";
    String update = "UPDATE students SET name = ?, email = ? WHERE id = ?";

    @Autowired
    public RepoTeacher(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Teacher> findAll() {
        RowMapper<Teacher> mapper = (rs, rowNum) -> {
            Teacher teacher = new Teacher();
            teacher.setId(rs.getLong("ID"));
            teacher.setName(rs.getString("name"));
            teacher.setEmail(rs.getString("email"));
            return teacher;

        };
        return jdbcTemplate.query(getAllQuery, mapper);
    }

    public void add(Teacher teacher) {
        int rows = jdbcTemplate.update(addQuery, teacher.getName(), teacher.getEmail());
        System.out.println(rows + " Added");
    }


    public Teacher findByID(Long id) {
        RowMapper<Teacher> mapper = (rs, rowNum) -> {
            Teacher teacher = new Teacher();
            teacher.setId(rs.getLong("ID"));
            teacher.setName(rs.getString("name"));
            teacher.setEmail(rs.getString("email"));
            return teacher;

        };
        return jdbcTemplate.queryForObject(getByID, mapper, id);
    }

    public void update(Teacher teacher) {
        int rows = jdbcTemplate.update(update, teacher.getName(), teacher.getEmail(), teacher.getId());
        System.out.println(rows + " Updated");
    }

}

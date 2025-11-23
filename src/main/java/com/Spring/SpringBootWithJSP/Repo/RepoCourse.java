package com.Spring.SpringBootWithJSP.Repo;


import com.Spring.SpringBootWithJSP.Model.Course;
import com.Spring.SpringBootWithJSP.Model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepoCourse {

    List<Course> courses = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;
    String getAllQuery = "select * from students ";
    String addQuery = "INSERT INTO students(name,email) VALUES(?,?)";

    @Autowired
    public RepoCourse( JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Course> findAll() {
        RowMapper<Course> mapper = (rs, rowNum) -> {
            Course course = new Course();
            course.setId(rs.getLong("ID"));
            course.setCode(rs.getString("code"));
            course.setTitle(rs.getString("title"));
            return course;

        };
        return jdbcTemplate.query(getAllQuery, mapper);
    }

    public void add(Course course) {
        int rows = jdbcTemplate.update(addQuery, course.getCode(), course.getTitle());
        System.out.println(rows + " Added");
    }


}

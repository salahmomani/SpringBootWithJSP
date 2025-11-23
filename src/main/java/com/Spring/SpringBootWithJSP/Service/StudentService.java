package com.Spring.SpringBootWithJSP.Service;

import com.Spring.SpringBootWithJSP.Model.Student;
import com.Spring.SpringBootWithJSP.Repo.RepoStudents;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    private final RepoStudents repoStudents;

    public StudentService(RepoStudents repoStudents) {
        this.repoStudents = repoStudents;
    }

    public List<Student> findAll() {
        return repoStudents.findAll();
    }

    public void add(Student student) {
        repoStudents.add(student);
    }

    public Student findByID(Long id) {
        return repoStudents.findByID(id);
    }

    public void update(Student student) {
        repoStudents.update(student);
    }
}

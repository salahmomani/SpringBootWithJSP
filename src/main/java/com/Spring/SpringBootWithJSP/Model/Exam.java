package com.Spring.SpringBootWithJSP.Model;

public class Exam {
    private Long id;
    private Long courseId;
    private String name;
    private int maxScore;

    public Exam() {
    }

    public Exam(Long id, Long courseId, String name, int maxScore) {
        this.id = id;
        this.courseId = courseId;
        this.name = name;
        this.maxScore = maxScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
}

package com.example.lab8q4;

public class Student {

    private int id;
    private String name;
    private String studentId;
    private String semester;
    private String branch;
    private String faculty;

    public Student() {
        // Empty constructor required by SQLite
    }

    public Student(String name, String studentId, String semester, String branch, String faculty) {
        this.name = name;
        this.studentId = studentId;
        this.semester = semester;
        this.branch = branch;
        this.faculty = faculty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentId='" + studentId + '\'' +
                ", semester='" + semester + '\'' +
                ", branch='" + branch + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}


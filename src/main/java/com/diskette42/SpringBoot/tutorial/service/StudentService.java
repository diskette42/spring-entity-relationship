package com.diskette42.SpringBoot.tutorial.service;

import com.diskette42.SpringBoot.tutorial.entity.Student;

import java.util.List;

public interface StudentService {
    public Student createStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudentById(Long id);
}

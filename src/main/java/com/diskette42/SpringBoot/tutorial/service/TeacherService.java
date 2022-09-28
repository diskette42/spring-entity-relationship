package com.diskette42.SpringBoot.tutorial.service;

import com.diskette42.SpringBoot.tutorial.entity.Student;
import com.diskette42.SpringBoot.tutorial.entity.Teacher;

import java.util.List;

public interface TeacherService {
    public Teacher createTeacher(Teacher teacher);
    public List<Teacher> getAllTeachers();
    public Teacher getTeacherById(Long id);
}

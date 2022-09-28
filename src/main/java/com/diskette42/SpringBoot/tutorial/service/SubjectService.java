package com.diskette42.SpringBoot.tutorial.service;

import com.diskette42.SpringBoot.tutorial.entity.Department;
import com.diskette42.SpringBoot.tutorial.entity.Student;
import com.diskette42.SpringBoot.tutorial.entity.Subject;
import com.diskette42.SpringBoot.tutorial.entity.Teacher;

import java.util.List;

public interface SubjectService {

    public Subject createSubject(Subject subject);
    public List<Subject> getAllSubjects();
    public Subject getSubjectById(Long id);
    public Subject getSubjectBySubjectCode(String code);

    public Subject setSubjectDp(Subject subject, Department department);
    public Subject setSubjectTeacher(Subject subject, Teacher teacher);

    public Subject subjectEnrolledByStudentId(Subject subject,Student student);

}

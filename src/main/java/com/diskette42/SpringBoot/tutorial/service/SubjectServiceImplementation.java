package com.diskette42.SpringBoot.tutorial.service;

import com.diskette42.SpringBoot.tutorial.entity.Department;
import com.diskette42.SpringBoot.tutorial.entity.Student;
import com.diskette42.SpringBoot.tutorial.entity.Subject;
import com.diskette42.SpringBoot.tutorial.entity.Teacher;
import com.diskette42.SpringBoot.tutorial.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImplementation implements SubjectService{

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).get();
    }

    @Override
    public Subject getSubjectBySubjectCode(String code) {
        return subjectRepository.findBySubjectCode(code);
    }

    @Override
    public Subject setSubjectDp(Subject subject, Department department) {
        subject.setDepartment(department);
        return subjectRepository.save(subject);
    }

    @Override
    public Subject setSubjectTeacher(Subject subject, Teacher teacher) {
        subject.setTeacher(teacher);
        return subjectRepository.save(subject);
    }

    @Override
    public Subject subjectEnrolledByStudentId(Subject subject, Student student) {
        subject.addStudents(student);
        return subjectRepository.save(subject);
    }
}

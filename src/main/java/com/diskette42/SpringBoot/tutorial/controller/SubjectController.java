package com.diskette42.SpringBoot.tutorial.controller;

import com.diskette42.SpringBoot.tutorial.dto.SubjectDpDto;
import com.diskette42.SpringBoot.tutorial.dto.SubjectTeacherDto;
import com.diskette42.SpringBoot.tutorial.entity.Department;
import com.diskette42.SpringBoot.tutorial.entity.Student;
import com.diskette42.SpringBoot.tutorial.entity.Subject;
import com.diskette42.SpringBoot.tutorial.entity.Teacher;
import com.diskette42.SpringBoot.tutorial.error.DepartmentNotFoundException;
import com.diskette42.SpringBoot.tutorial.service.DepartmentService;
import com.diskette42.SpringBoot.tutorial.service.StudentService;
import com.diskette42.SpringBoot.tutorial.service.SubjectService;
import com.diskette42.SpringBoot.tutorial.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/subjects")
    public Subject createSubject(@Valid @RequestBody Subject subject){
        return  subjectService.createSubject(subject);
    }

    @GetMapping("/subjects")
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @GetMapping("/subjects/{code}")
    public Subject getSubjectById(@PathVariable("code") String code){
        return subjectService.getSubjectBySubjectCode(code);
    }

    @PostMapping("/subjects/add-department")
    public Subject setSubjectDp(@Valid @RequestBody SubjectDpDto res) throws DepartmentNotFoundException {
        System.out.println(res.getSubjectCode());
        System.out.println(res.getDepartmentId());
        Subject subject  = subjectService.getSubjectBySubjectCode(res.getSubjectCode());
        Department department = departmentService.getDepartmentById(res.getDepartmentId());

//        subjectService.createSubject(subject);
        return subjectService.setSubjectDp(subject,department);
    }

    @PostMapping("/subjects/add-teacher")
    public Subject setSubjectTeacher(@Valid @RequestBody SubjectTeacherDto res) throws DepartmentNotFoundException {
        Subject subject  = subjectService.getSubjectBySubjectCode(res.getSubjectCode());
        Teacher teacher = teacherService.getTeacherById(res.getTeacherId());

//        subjectService.createSubject(subject);
        return subjectService.setSubjectTeacher(subject,teacher);
    }

    @PutMapping("/subjects/{subjectId}/students/{studentId}")
    public Subject subjectEnrolledByStudentId(@PathVariable("subjectId") Long subjectId, @PathVariable("studentId") Long studentId){
        Subject subject = subjectService.getSubjectById(subjectId);
        Student student = studentService.getStudentById(studentId);

        return subjectService.subjectEnrolledByStudentId(subject,student);
    }

}

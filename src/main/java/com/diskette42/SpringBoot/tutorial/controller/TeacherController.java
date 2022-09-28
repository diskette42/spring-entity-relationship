package com.diskette42.SpringBoot.tutorial.controller;

import com.diskette42.SpringBoot.tutorial.entity.Student;
import com.diskette42.SpringBoot.tutorial.entity.Teacher;
import com.diskette42.SpringBoot.tutorial.service.StudentService;
import com.diskette42.SpringBoot.tutorial.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/teachers")
    public Teacher createTeacher(@Valid @RequestBody Teacher teacher){
        return  teacherService.createTeacher(teacher);
    }

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/teachers/{id}")
    public Teacher getTeacherById(@PathVariable("id") Long id){
        return teacherService.getTeacherById(id);
    }
}

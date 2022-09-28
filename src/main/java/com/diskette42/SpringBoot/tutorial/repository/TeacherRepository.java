package com.diskette42.SpringBoot.tutorial.repository;

import com.diskette42.SpringBoot.tutorial.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}

package com.diskette42.SpringBoot.tutorial.repository;

import com.diskette42.SpringBoot.tutorial.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
    public Subject findBySubjectCode(String name);
}

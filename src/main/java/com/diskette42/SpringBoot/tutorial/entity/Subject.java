package com.diskette42.SpringBoot.tutorial.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;
    @NotBlank(message = "Please add subject name")
    private String subjectName;
    @NotBlank(message = "Please add subject code")
    private String subjectCode;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="teacherId",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="departmentId",
            referencedColumnName = "departmentId"
    )
    private Department department;

    @ManyToMany
    @JoinTable(
            name="enrolled",
            joinColumns = @JoinColumn(name = "subjectId"),
            inverseJoinColumns = @JoinColumn(name ="studentId")
    )
    private List<Student> students;

    public void addStudents(Student student){
        if(student != null ){
            students.add(student);
        }
    }
}

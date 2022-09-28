package com.diskette42.SpringBoot.tutorial.dto;

public class SubjectTeacherDto {
    private String subjectCode;
    private Long teacherId;

    public SubjectTeacherDto(String subjectCode, Long teacherId) {
        this.subjectCode = subjectCode;
        this.teacherId = teacherId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }



}

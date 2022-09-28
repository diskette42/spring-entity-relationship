package com.diskette42.SpringBoot.tutorial.dto;

public class SubjectDpDto {
    public String subjectCode;
    public Long departmentId;

    public SubjectDpDto(String subjectCode, Long departmentId) {
        this.subjectCode = subjectCode;
        this.departmentId = departmentId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}

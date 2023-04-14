package com.spangles.orgdepartmentmanagement.dto;

import java.io.Serializable;

public class SemesterDto implements Serializable {
    private Long semesterId;
    private Long semesterCode;
    private String semesterName;
    private Long departmentId;
    private Long semesterYear;

    public SemesterDto(){

    }
    public SemesterDto(Long semesterId,Long semesterCode,String semesterName,Long departmentId,Long semesterYear){
        this.semesterId = semesterId;
        this.semesterCode = semesterCode;
        this.semesterName = semesterName;
        this.departmentId = departmentId;
        this.semesterYear = semesterYear;
    }

    public Long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Long semesterId) {
        this.semesterId = semesterId;
    }

    public Long getSemesterCode() {
        return semesterCode;
    }

    public void setSemesterCode(Long semesterCode) {
        this.semesterCode = semesterCode;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getSemesterYear() {
        return semesterYear;
    }

    public void setSemesterYear(Long semesterYear) {
        this.semesterYear = semesterYear;
    }
}

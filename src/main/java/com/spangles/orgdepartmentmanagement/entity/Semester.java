package com.spangles.orgdepartmentmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "semester_id")
    private Long semesterId;
    @Column(name = "semester_code")
    private Long semesterCode;
    @Column(name = "semester_name")
    private String semesterName;
    @Column(name = "department_id")
    private Long departmentId;
    @Column(name = "semester_year")
    private Long semesterYear;

    public Semester(){

    }
    public Semester(Long semesterId,Long semesterCode,String semesterName,Long departmentId,Long semesterYear){
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

package com.spangles.orgdepartmentmanagement.util;

import com.spangles.orgdepartmentmanagement.dto.DepartmentDto;
import com.spangles.orgdepartmentmanagement.dto.SemesterDto;
import com.spangles.orgdepartmentmanagement.dto.SubjectDto;
import com.spangles.orgdepartmentmanagement.entity.Department;
import com.spangles.orgdepartmentmanagement.entity.Semester;
import com.spangles.orgdepartmentmanagement.entity.Subject;

import java.io.Serializable;

public class DepartmentUtil implements Serializable {

    public SubjectDto convertingEntityToDto(Subject subject){

        SubjectDto subjectDto = new SubjectDto();

        subjectDto.setSubjectId(subject.getSubjectId());
        subjectDto.setSubjectCode(subject.getSubjectCode());
        subjectDto.setSubjectName(subject.getSubjectName());
        subjectDto.setTotalMark(subject.getTotalMark());
        subjectDto.setPassMark(subject.getPassMark());
        subjectDto.setSubjectType(subject.getSubjectType());

        return subjectDto;
    }
    public Subject convertingDtoToEntity(SubjectDto subjectDto){

        Subject subject = new Subject();

        subject.setSubjectId(subjectDto.getSubjectId());
        subject.setSubjectCode(subjectDto.getSubjectCode());
        subject.setSubjectName(subjectDto.getSubjectName());
        subject.setTotalMark(subjectDto.getTotalMark());
        subject.setPassMark(subjectDto.getPassMark());
        subject.setSubjectType(subjectDto.getSubjectType());

        return subject;
    }
    public DepartmentDto convertingEntityToDto(Department department){
        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setDepartmentId(department.getDepartmentId());
        departmentDto.setDepartmentCode(department.getDepartmentCode());
        departmentDto.setDepartmentName(department.getDepartmentName());
        departmentDto.setHeadOfTheDepartment(department.getHeadOfTheDepartment());

        return departmentDto;
    }
    public Department convertingDtoToEntity(DepartmentDto departmentDto){
        Department department = new Department();

        department.setDepartmentId(departmentDto.getDepartmentId());
        department.setDepartmentCode(departmentDto.getDepartmentCode());
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setHeadOfTheDepartment(departmentDto.getHeadOfTheDepartment());

        return department;
    }
    public SemesterDto convertingEntityToDto(Semester semester){
        SemesterDto semesterDto = new SemesterDto();

        semesterDto.setSemesterId(semester.getSemesterId());
        semesterDto.setSemesterCode(semester.getSemesterCode());
        semesterDto.setSemesterName(semester.getSemesterName());
        semesterDto.setDepartmentId(semester.getDepartmentId());
        semesterDto.setSemesterYear(semester.getSemesterYear());

        return semesterDto;
    }
    public Semester convertingDtoToEntity(SemesterDto semesterDto){
        Semester semester = new Semester();

        semester.setSemesterId(semesterDto.getSemesterId());
        semester.setSemesterCode(semesterDto.getSemesterCode());
        semester.setSemesterName(semesterDto.getSemesterName());
        semester.setDepartmentId(semesterDto.getDepartmentId());
        semester.setSemesterYear(semesterDto.getSemesterYear());

        return semester;
    }
}

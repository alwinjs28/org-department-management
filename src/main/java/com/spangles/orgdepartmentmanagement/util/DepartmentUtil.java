package com.spangles.orgdepartmentmanagement.util;

import com.spangles.orgdepartmentmanagement.dto.SubjectDto;
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
}

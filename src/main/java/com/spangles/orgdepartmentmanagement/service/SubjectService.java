package com.spangles.orgdepartmentmanagement.service;

import com.spangles.orgdepartmentmanagement.dto.SubjectDto;
import com.spangles.orgdepartmentmanagement.dto.response.SubjectWrapperDto;

public interface SubjectService {
    public SubjectDto getSubject(Long subjectId);
    public SubjectWrapperDto saveSubject(SubjectDto subjectDto);
    public SubjectDto updateSubject(SubjectDto subjectDto);
    public void deleteSubject(SubjectDto subjectDto);
}

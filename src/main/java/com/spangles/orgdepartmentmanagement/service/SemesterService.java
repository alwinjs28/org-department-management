package com.spangles.orgdepartmentmanagement.service;

import com.spangles.orgdepartmentmanagement.dto.SemesterDto;
import com.spangles.orgdepartmentmanagement.dto.response.SemesterWrapperDto;

public interface SemesterService {
    public SemesterDto getSemester(Long semesterId);
    public SemesterWrapperDto saveSemester(SemesterDto semesterDto);
    public SemesterDto updateSemester(SemesterDto semesterDto);
    public void deleteSemester(SemesterDto semesterDto);
}

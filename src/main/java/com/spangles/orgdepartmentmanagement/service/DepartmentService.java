package com.spangles.orgdepartmentmanagement.service;

import com.spangles.orgdepartmentmanagement.dto.DepartmentDto;
import com.spangles.orgdepartmentmanagement.dto.response.DepartmentWrapperDto;

public interface DepartmentService {
    public DepartmentDto getDepartment(Long departmentId);
    public DepartmentWrapperDto saveDepartment(DepartmentDto departmentDto);
    public DepartmentDto updateDepartment(DepartmentDto departmentDto);
    public void deleteDepartment(DepartmentDto departmentDto);
    public boolean getStaffIdByHeadOfTheDepartment(Long headOfTheDepartment);
}

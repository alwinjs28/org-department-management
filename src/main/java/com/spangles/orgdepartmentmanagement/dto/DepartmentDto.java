package com.spangles.orgdepartmentmanagement.dto;

import java.io.Serializable;

public class DepartmentDto implements Serializable {
    private Long departmentId;
    private String departmentCode;
    private String departmentName;
    private Long headOfTheDepartment;

    public DepartmentDto(){

    }
    public DepartmentDto(Long departmentId,String departmentCode,String departmentName,Long headOfTheDepartment){
        this.departmentId = departmentId;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.headOfTheDepartment = headOfTheDepartment;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getHeadOfTheDepartment() {
        return headOfTheDepartment;
    }

    public void setHeadOfTheDepartment(Long headOfTheDepartment) {
        this.headOfTheDepartment = headOfTheDepartment;
    }
}

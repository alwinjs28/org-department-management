package com.spangles.orgdepartmentmanagement.dto.response;

import com.spangles.orgdepartmentmanagement.dto.DepartmentDto;

import java.io.Serializable;

public class DepartmentWrapperDto implements Serializable {
    private AdditionalHeaderDto additionalHeaderDto;
    private DepartmentDto departmentDto;

    public DepartmentWrapperDto(){

    }
    public DepartmentWrapperDto(AdditionalHeaderDto additionalHeaderDto,DepartmentDto departmentDto){
        this.additionalHeaderDto = additionalHeaderDto;
        this.departmentDto = departmentDto;
    }

    public AdditionalHeaderDto getAdditionalHeaderDto() {
        return additionalHeaderDto;
    }

    public void setAdditionalHeaderDto(AdditionalHeaderDto additionalHeaderDto) {
        this.additionalHeaderDto = additionalHeaderDto;
    }

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    public void setDepartmentDto(DepartmentDto departmentDto) {
        this.departmentDto = departmentDto;
    }
}

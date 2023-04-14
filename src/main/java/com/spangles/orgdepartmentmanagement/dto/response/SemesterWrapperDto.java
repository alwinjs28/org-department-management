package com.spangles.orgdepartmentmanagement.dto.response;

import com.spangles.orgdepartmentmanagement.dto.SemesterDto;

import java.io.Serializable;

public class SemesterWrapperDto implements Serializable {
    private SemesterDto semesterDto;
    private AdditionalHeaderDto additionalHeaderDto;

    public SemesterWrapperDto(){

    }
    public SemesterWrapperDto(SemesterDto semesterDto,AdditionalHeaderDto additionalHeaderDto){
        this.semesterDto = semesterDto;
        this.additionalHeaderDto = additionalHeaderDto;
    }

    public SemesterDto getSemesterDto() {
        return semesterDto;
    }

    public void setSemesterDto(SemesterDto semesterDto) {
        this.semesterDto = semesterDto;
    }

    public AdditionalHeaderDto getAdditionalHeaderDto() {
        return additionalHeaderDto;
    }

    public void setAdditionalHeaderDto(AdditionalHeaderDto additionalHeaderDto) {
        this.additionalHeaderDto = additionalHeaderDto;
    }
}

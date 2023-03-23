package com.spangles.orgdepartmentmanagement.dto.response;

import com.spangles.orgdepartmentmanagement.dto.SubjectDto;

import java.io.Serializable;

public class SubjectWrapperDto implements Serializable {
    private SubjectDto subjectDto;
    private AdditionalHeaderDto additionalHeaderDto;

    public SubjectWrapperDto(){

    }
    public SubjectWrapperDto(SubjectDto subjectDto,AdditionalHeaderDto additionalHeaderDto){
        this.subjectDto = subjectDto;
        this.additionalHeaderDto = additionalHeaderDto;
    }

    public SubjectDto getSubjectDto() {
        return subjectDto;
    }

    public void setSubjectDto(SubjectDto subjectDto) {
        this.subjectDto = subjectDto;
    }

    public AdditionalHeaderDto getAdditionalHeaderDto() {
        return additionalHeaderDto;
    }

    public void setAdditionalHeaderDto(AdditionalHeaderDto additionalHeaderDto) {
        this.additionalHeaderDto = additionalHeaderDto;
    }
}

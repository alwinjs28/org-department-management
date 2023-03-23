package com.spangles.orgdepartmentmanagement.dto;

import java.io.Serializable;

public class SubjectDto implements Serializable {
    private Long subjectId;
    private String subjectCode;
    private String subjectName;
    private Integer totalMark;
    private Integer passMark;
    private String subjectType;

    public SubjectDto(){

    }
    public SubjectDto(Long subjectId,String subjectCode,String subjectName,Integer totalMark,Integer passMark,String subjectType){
        this.subjectId = subjectId;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.totalMark = totalMark;
        this.passMark = passMark;
        this.subjectType = subjectType;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(Integer totalMark) {
        this.totalMark = totalMark;
    }

    public Integer getPassMark() {
        return passMark;
    }

    public void setPassMark(Integer passMark) {
        this.passMark = passMark;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }
}

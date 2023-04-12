package com.spangles.orgdepartmentmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmentId")
    private Long departmentId;
    @Column(name = "departmentCode")
    private String departmentCode;
    @Column(name = "departmentName")
    private String departmentName;
    @Column(name = "headOfTheDepartment")
    private Long headOfTheDepartment;

    public Department(){

    }
    public Department(Long departmentId,String departmentCode,String departmentName,Long headOfTheDepartment){
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

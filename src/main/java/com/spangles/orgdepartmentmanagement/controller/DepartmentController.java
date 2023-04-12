package com.spangles.orgdepartmentmanagement.controller;

import com.spangles.orgdepartmentmanagement.dto.DepartmentDto;
import com.spangles.orgdepartmentmanagement.dto.SubjectDto;
import com.spangles.orgdepartmentmanagement.dto.response.DepartmentWrapperDto;
import com.spangles.orgdepartmentmanagement.dto.response.SubjectWrapperDto;
import com.spangles.orgdepartmentmanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "department")
@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "g_department/{department_id}",method = RequestMethod.GET)
    @ResponseBody
    public DepartmentDto getDepartment(@PathVariable("department_id") Long departmentId){
        return departmentService.getDepartment(departmentId);
    }
    @RequestMapping(value = "/s_department",method = RequestMethod.POST)
    @ResponseBody
    public DepartmentWrapperDto saveDepartment(@RequestBody DepartmentDto departmentDto){
        return departmentService.saveDepartment(departmentDto);
    }
    @RequestMapping(value = "/u_department",method = RequestMethod.PUT)
    @ResponseBody
    public DepartmentDto updateDepartment(@RequestBody DepartmentDto departmentDto){
        return departmentService.updateDepartment(departmentDto);
    }
    @RequestMapping(value = "/d_department",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteDepartment(@RequestBody DepartmentDto departmentDto){
        departmentService.deleteDepartment(departmentDto);
    }

}

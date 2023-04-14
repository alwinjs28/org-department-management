package com.spangles.orgdepartmentmanagement.controller;

import com.spangles.orgdepartmentmanagement.dto.DepartmentDto;
import com.spangles.orgdepartmentmanagement.dto.SemesterDto;
import com.spangles.orgdepartmentmanagement.dto.response.DepartmentWrapperDto;
import com.spangles.orgdepartmentmanagement.dto.response.SemesterWrapperDto;
import com.spangles.orgdepartmentmanagement.service.DepartmentService;
import com.spangles.orgdepartmentmanagement.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "semester")
@RestController
public class SemesterController {

    @Autowired
    SemesterService semesterService;

    @RequestMapping(value = "g_semester/{semester_id}",method = RequestMethod.GET)
    @ResponseBody
    public SemesterDto getSemester(@PathVariable("semester_id") Long semesterId){
        return semesterService.getSemester(semesterId);
    }
    @RequestMapping(value = "/s_semester",method = RequestMethod.POST)
    @ResponseBody
    public SemesterWrapperDto saveSemester(@RequestBody SemesterDto semesterDto){
        return semesterService.saveSemester(semesterDto);
    }
    @RequestMapping(value = "/u_semester",method = RequestMethod.PUT)
    @ResponseBody
    public SemesterDto updateSemester(@RequestBody SemesterDto semesterDto){
        return semesterService.updateSemester(semesterDto);
    }
    @RequestMapping(value = "/d_semester",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteSemester(@RequestBody SemesterDto semesterDto){
        semesterService.deleteSemester(semesterDto);
    }
}

package com.spangles.orgdepartmentmanagement.controller;

import com.spangles.orgdepartmentmanagement.dto.SubjectDto;
import com.spangles.orgdepartmentmanagement.dto.response.SubjectWrapperDto;
import com.spangles.orgdepartmentmanagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "subject")
@RestController
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @RequestMapping(value = "g_subject/{subject_id}",method = RequestMethod.GET)
    @ResponseBody
    public SubjectDto getSubject(@PathVariable ("subject_id") Long subjectId){
        return subjectService.getSubject(subjectId);
    }
    @RequestMapping(value = "/s_subject",method = RequestMethod.POST)
    @ResponseBody
    public SubjectWrapperDto saveSubject(@RequestBody SubjectDto subjectDto){
        return subjectService.saveSubject(subjectDto);
    }
    @RequestMapping(value = "/u_subject",method = RequestMethod.PUT)
    @ResponseBody
    public SubjectDto updateSubject(@RequestBody SubjectDto subjectDto){
        return subjectService.updateSubject(subjectDto);
    }
    @RequestMapping(value = "/d_subject",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteSubject(@RequestBody SubjectDto subjectDto){
        subjectService.deleteSubject(subjectDto);
    }

}

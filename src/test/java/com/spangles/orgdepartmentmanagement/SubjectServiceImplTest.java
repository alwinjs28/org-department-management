package com.spangles.orgdepartmentmanagement;

import com.spangles.orgdepartmentmanagement.controller.SubjectController;
import com.spangles.orgdepartmentmanagement.dto.SubjectDto;
import com.spangles.orgdepartmentmanagement.dto.response.SubjectWrapperDto;
import com.spangles.orgdepartmentmanagement.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SubjectServiceImplTest {
    @Autowired
    SubjectService subjectService;

    @Test
    public void saveSubjectTest(){
        String subjectCode = "ME001";
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setSubjectCode(subjectCode);
        SubjectWrapperDto subjectWrapperDto = subjectService.saveSubject(subjectDto);
    }
}

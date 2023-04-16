package com.spangles.orgdepartmentmanagement;

import com.spangles.orgdepartmentmanagement.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DepartmentServiceImplTest {
    @Autowired
    DepartmentService departmentService;
    @Test
    public void getStaffIdByHeadOfTheDepartment(){
        Long headOfTheDepartment = 1L;
//        boolean value = departmentService.getStaffIdByHeadOfTheDepartment(headOfTheDepartment);
    }
}

package com.spangles.orgdepartmentmanagement.service.impl;

import com.spangles.orgdepartmentmanagement.dto.SemesterDto;
import com.spangles.orgdepartmentmanagement.dto.response.AdditionalHeaderDto;
import com.spangles.orgdepartmentmanagement.dto.response.SemesterWrapperDto;
import com.spangles.orgdepartmentmanagement.entity.Department;
import com.spangles.orgdepartmentmanagement.entity.Semester;
import com.spangles.orgdepartmentmanagement.repositoty.DepartmentRepository;
import com.spangles.orgdepartmentmanagement.repositoty.SemesterRepository;
import com.spangles.orgdepartmentmanagement.service.SemesterService;
import com.spangles.orgdepartmentmanagement.util.Constants;
import com.spangles.orgdepartmentmanagement.util.DepartmentUtil;
import com.spangles.orgdepartmentmanagement.util.HttpStatus;
import com.spangles.orgdepartmentmanagement.util.MessageLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SemesterServiceImpl implements SemesterService {

    @Autowired
    SemesterRepository semesterRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Value("${number.of.years}")
    private Integer numberOfYears;
    @Override
    public SemesterDto getSemester(Long semesterId) {
        DepartmentUtil departmentUtil = new DepartmentUtil();
        Semester semester = semesterRepository.getSemester(semesterId);
        SemesterDto semesterDto = departmentUtil.convertingEntityToDto(semester);
        return semesterDto;
    }

    @Override
    public SemesterWrapperDto saveSemester(SemesterDto semesterDto) {
        AdditionalHeaderDto additionalHeaderDto = new AdditionalHeaderDto();
        SemesterWrapperDto semesterWrapperDto = new SemesterWrapperDto();
        if (semesterDto != null){
            Semester semesterCodeExist = semesterRepository.getSemesterBySemesterCode(semesterDto.getSemesterCode());
            if (semesterCodeExist == null){
                Semester semesterNameExist = semesterRepository.getSemesterBySemesterName(semesterDto.getSemesterName());
                if (semesterNameExist == null) {
                    Department departmentIdExist = departmentRepository.getDepartment(semesterDto.getDepartmentId());
                    if (departmentIdExist != null) {
                        if (semesterDto.getSemesterYear() > 0 && semesterDto.getSemesterYear() <= numberOfYears){
                            DepartmentUtil departmentUtil = new DepartmentUtil();
                            Semester semester = departmentUtil.convertingDtoToEntity(semesterDto);
                            Semester saveSemester = semesterRepository.save(semester);
                            SemesterDto semesterDtoResponse = departmentUtil.convertingEntityToDto(saveSemester);

                            additionalHeaderDto.setMessageLevel(Constants.DEPARTMENT_ID+semesterDto.getDepartmentId());
                            additionalHeaderDto.setMessageLevel(MessageLevel.INFO.toString());
                            additionalHeaderDto.setHttpStatus(HttpStatus.SUCCESS.statusCode());
                            semesterWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
                            semesterWrapperDto.setSemesterDto(semesterDtoResponse);
                        }else {
                            additionalHeaderDto.setMessage(Constants.NUMBER_OF_YEAR_LIMIT);
                            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
                            additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
                            semesterWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
                        }
                    }else {
                        additionalHeaderDto.setMessage(Constants.INPUT_IS_NOT_FOUND_IN_DEPARTMENT);
                        additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
                        additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
                        semesterWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
                    }
                }else {
                    additionalHeaderDto.setMessage(Constants.INPUT_IS_ALREADY_GIVEN_SEMESTER_NAME);
                    additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
                    additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
                    semesterWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
                }
            }else {
                additionalHeaderDto.setMessage(Constants.INPUT_IS_ALREADY_GIVEN_SEMESTER_CODE);
                additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
                additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
                semesterWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
            }
        }
        return semesterWrapperDto;
    }

    @Override
    public SemesterDto updateSemester(SemesterDto semesterDto) {
        DepartmentUtil departmentUtil = new DepartmentUtil();
        Semester semester = departmentUtil.convertingDtoToEntity(semesterDto);
        Semester semesterEntity = semesterRepository.save(semester);
        SemesterDto semesterDtoResponse = departmentUtil.convertingEntityToDto(semesterEntity);
        return semesterDtoResponse;
    }

    @Override
    public void deleteSemester(SemesterDto semesterDto) {
        DepartmentUtil departmentUtil = new DepartmentUtil();
        Semester semester = departmentUtil.convertingDtoToEntity(semesterDto);
        semesterRepository.delete(semester);
    }
}

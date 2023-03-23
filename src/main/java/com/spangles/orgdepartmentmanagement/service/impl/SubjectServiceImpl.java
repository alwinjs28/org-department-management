package com.spangles.orgdepartmentmanagement.service.impl;

import com.spangles.orgdepartmentmanagement.dto.SubjectDto;
import com.spangles.orgdepartmentmanagement.dto.response.AdditionalHeaderDto;
import com.spangles.orgdepartmentmanagement.dto.response.SubjectWrapperDto;
import com.spangles.orgdepartmentmanagement.entity.Subject;
import com.spangles.orgdepartmentmanagement.repositoty.SubjectRepository;
import com.spangles.orgdepartmentmanagement.service.SubjectService;
import com.spangles.orgdepartmentmanagement.util.Constants;
import com.spangles.orgdepartmentmanagement.util.DepartmentUtil;
import com.spangles.orgdepartmentmanagement.util.HttpStatus;
import com.spangles.orgdepartmentmanagement.util.MessageLevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    @Value("${total.mark.limit}")
    private Integer totalMarkLimit;
    @Value("${pass.mark.limit}")
    private Integer passMarkLimit;
    @Value("${subject.types}")
    private String subjectTypes;
    @Override
    public SubjectDto getSubject(Long subjectId) {
        Subject subject = subjectRepository.getSubject(subjectId);
        DepartmentUtil departmentUtil = new DepartmentUtil();
        SubjectDto subjectDto = departmentUtil.convertingEntityToDto(subject);
        return subjectDto;
    }

    @Override
    public SubjectWrapperDto saveSubject(SubjectDto subjectDto) {

        AdditionalHeaderDto additionalHeaderDto = new AdditionalHeaderDto();
        SubjectWrapperDto subjectWrapperDto = new SubjectWrapperDto();
        if(subjectDto != null) {
            Subject subjectCodeExist = subjectRepository.getSubjectBySubjectCode(subjectDto.getSubjectCode());
            if (subjectCodeExist == null) {//This is the new record
                Subject subjectNameExist = subjectRepository.getSubjectBySubjectName(subjectDto.getSubjectName());
                if (subjectNameExist == null) {
                    if (subjectDto.getTotalMark()>0 && subjectDto.getTotalMark()<=totalMarkLimit) {
                        if(subjectDto.getPassMark()>=passMarkLimit) {
                            if (checkSubjectType(subjectDto.getSubjectType())) {
                                DepartmentUtil departmentUtil = new DepartmentUtil();
                                Subject subject = departmentUtil.convertingDtoToEntity(subjectDto);
                                Subject saveSubject = subjectRepository.save(subject);
                                SubjectDto subjectDtoResponse = departmentUtil.convertingEntityToDto(saveSubject);

                                additionalHeaderDto.setMessage(Constants.SUBJECT_ID+subjectDto.getSubjectId());
                                additionalHeaderDto.setMessageLevel(MessageLevel.INFO.toString());
                                additionalHeaderDto.setHttpStatus(HttpStatus.SUCCESS.statusCode());
                                subjectWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
                                subjectWrapperDto.setSubjectDto(subjectDtoResponse);
                            }else {
                                additionalHeaderDto.setMessage(Constants.SUBJECT_TYPE+subjectDto.getSubjectType());
                                additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
                                additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
                                subjectWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
                            }
                        }else {
                            additionalHeaderDto.setMessage(Constants.PASS_MARK_LIMIT+subjectDto.getPassMark());
                            additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
                            additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
                            subjectWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
                        }
                    }else {
                        additionalHeaderDto.setMessage(Constants.TOTAL_MARK_LIMIT+subjectDto.getTotalMark());
                        additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
                        additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
                        subjectWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
                    }
                }else {
                    additionalHeaderDto.setMessage(Constants.INPUT_NOT_GIVEN_SUBJECT_NAME);
                    additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
                    additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
                    subjectWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
                }
            }else {//Throw the exception
                additionalHeaderDto.setMessage(Constants.INPUT_NOT_GIVEN_SUBJECT_CODE);
                additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
                additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
                subjectWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);

            }
        }
        return subjectWrapperDto;
    }
    public boolean checkSubjectType(String subjectType) {
        String splitSubjectType[] = subjectTypes.split(",");
        boolean inputSubjectType = false;
        for (String subjectTypes : splitSubjectType) {
            log.info("name : {}", subjectType);
            if (subjectType.equals(subjectTypes)) {
                inputSubjectType = true;
            }
        }
        return inputSubjectType;
    }

    @Override
    public SubjectDto updateSubject(SubjectDto subjectDto) {
        DepartmentUtil departmentUtil = new DepartmentUtil();
        Subject subject = departmentUtil.convertingDtoToEntity(subjectDto);
        Subject subjectEntity = subjectRepository.save(subject);
        SubjectDto subjectDtoResponse = departmentUtil.convertingEntityToDto(subjectEntity);
        return subjectDtoResponse;
    }

    @Override
    public void deleteSubject(SubjectDto subjectDto) {
        DepartmentUtil departmentUtil = new DepartmentUtil();
        Subject subject = departmentUtil.convertingDtoToEntity(subjectDto);
        subjectRepository.delete(subject);
    }
}

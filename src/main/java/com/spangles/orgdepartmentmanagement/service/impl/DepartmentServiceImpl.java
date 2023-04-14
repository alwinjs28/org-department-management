package com.spangles.orgdepartmentmanagement.service.impl;

import com.spangles.orgdepartmentmanagement.dto.DepartmentDto;
import com.spangles.orgdepartmentmanagement.dto.response.AdditionalHeaderDto;
import com.spangles.orgdepartmentmanagement.dto.response.DepartmentWrapperDto;
import com.spangles.orgdepartmentmanagement.entity.Department;
import com.spangles.orgdepartmentmanagement.repositoty.DepartmentRepository;
import com.spangles.orgdepartmentmanagement.service.DepartmentService;
import com.spangles.orgdepartmentmanagement.util.Constants;
import com.spangles.orgdepartmentmanagement.util.DepartmentUtil;
import com.spangles.orgdepartmentmanagement.util.HttpStatus;
import com.spangles.orgdepartmentmanagement.util.MessageLevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    RestTemplate restTemplate;
    @Value("${org.staff.service.address}")
    private String staffServiceAddress;

    @Override
    public DepartmentDto getDepartment(Long departmentId) {
        Department department = departmentRepository.getDepartment(departmentId);
        DepartmentUtil departmentUtil = new DepartmentUtil();
        DepartmentDto departmentDto = departmentUtil.convertingEntityToDto(department);
        return departmentDto;
    }

    @Override
    public DepartmentWrapperDto saveDepartment(DepartmentDto departmentDto) {
        AdditionalHeaderDto additionalHeaderDto = new AdditionalHeaderDto();
        DepartmentWrapperDto departmentWrapperDto = new DepartmentWrapperDto();
        if(departmentDto != null){
            Department departmentCodeExist = departmentRepository.getDepartmentByDepartmentCode(departmentDto.getDepartmentCode());
            if (departmentCodeExist == null){
                Department departmentNameExist = departmentRepository.getDepartmentByDepartmentName(departmentDto.getDepartmentName());
                if (departmentNameExist == null){
                    if (getStaffIdByHeadOfTheDepartment(departmentDto.getHeadOfTheDepartment())){
                        DepartmentUtil departmentUtil = new DepartmentUtil();
                        Department department = departmentUtil.convertingDtoToEntity(departmentDto);
                        Department saveDepartment = departmentRepository.save(department);
                        DepartmentDto departmentDtoResponse = departmentUtil.convertingEntityToDto(saveDepartment);

                        additionalHeaderDto.setMessageLevel(Constants.STAFF_ID+departmentDto.getHeadOfTheDepartment());
                        additionalHeaderDto.setMessageLevel(MessageLevel.INFO.toString());
                        additionalHeaderDto.setHttpStatus(HttpStatus.SUCCESS.statusCode());
                        departmentWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
                        departmentWrapperDto.setDepartmentDto(departmentDtoResponse);
                    }else {
                        additionalHeaderDto.setMessage(Constants.INPUT_STAFF_ID_NOT_VALID);
                        additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
                        additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
                        departmentWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
                    }
                }else {
                    additionalHeaderDto.setMessage(Constants.INPUT_IS_ALREADY_GIVEN_DEPARTMENT_NAME);
                    additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
                    additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
                    departmentWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
                }
            }else{
                additionalHeaderDto.setMessage(Constants.INPUT_IS_ALREADY_GIVEN_DEPARTMENT_CODE);
                additionalHeaderDto.setMessageLevel(MessageLevel.ERROR.toString());
                additionalHeaderDto.setHttpStatus(HttpStatus.BAD_REQUEST.statusCode());
                departmentWrapperDto.setAdditionalHeaderDto(additionalHeaderDto);
            }
        }
        return departmentWrapperDto;
    }
    // input is staffId return staffDto
    public boolean getStaffIdByHeadOfTheDepartment(Long headOfTheDepartment){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        String url = staffServiceAddress.concat(Constants.GET_STAFF_BY_ID_URL);
        String urlWithQueryParam = url.concat(Constants.STAFF_QUERY).concat(String.valueOf(headOfTheDepartment));
        log.info("url {}",urlWithQueryParam);
        ResponseEntity<String> staffResponseEntity = restTemplate.exchange(urlWithQueryParam, HttpMethod.GET, httpEntity, String.class);
        boolean result = false;
        int staffId = 0;
        if (staffResponseEntity.getStatusCodeValue() == 200){
            if (staffResponseEntity.getBody() != null){
                String stringifyJSON = staffResponseEntity.getBody();
                log.info("staff response : {}",stringifyJSON);
                String jsonResponse[] = stringifyJSON.split("\"staffName\":\"")[0].split("\"staffId\":");
                String staffIdStr = jsonResponse[1].replace(",","");
                //log.info("print :{}",stringifyJSON.split("\"staffName\":\"")[0].split("\"staffId\":"));
                log.info("staffId : {}",staffIdStr);
                staffId = Integer.parseInt(staffIdStr);
            }
        }
        if (staffId>0){
            result = true;
        }
        return result;
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto) {
        DepartmentUtil departmentUtil = new DepartmentUtil();
        Department department = departmentUtil.convertingDtoToEntity(departmentDto);
        Department departmentEntity = departmentRepository.save(department);
        DepartmentDto departmentDtoResponse = departmentUtil.convertingEntityToDto(departmentEntity);
        return departmentDtoResponse;
    }

    @Override
    public void deleteDepartment(DepartmentDto departmentDto) {
        DepartmentUtil departmentUtil = new DepartmentUtil();
        Department department = departmentUtil.convertingDtoToEntity(departmentDto);
        departmentRepository.delete(department);
    }
}

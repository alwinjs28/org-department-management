package com.spangles.orgdepartmentmanagement.dto.response;

import java.io.Serializable;

public class AdditionalHeaderDto implements Serializable {
    private String message;
    private String messageLevel;
    private int httpStatus;

    public AdditionalHeaderDto(){

    }
    public AdditionalHeaderDto(String message,String messageLevel,int httpStatus){
        this.message = message;
        this.messageLevel = messageLevel;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageLevel() {
        return messageLevel;
    }

    public void setMessageLevel(String messageLevel) {
        this.messageLevel = messageLevel;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }
}

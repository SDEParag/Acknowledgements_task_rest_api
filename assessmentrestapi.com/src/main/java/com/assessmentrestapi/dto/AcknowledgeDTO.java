package com.assessmentrestapi.dto;

import java.time.LocalDateTime;

public class AcknowledgeDTO {
    private String userName;
    private String clientName;

    public AcknowledgeDTO() {}

    public AcknowledgeDTO(String userName, String clientName) {
        this.userName = userName;
        this.clientName = clientName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "AcknowledgeDTO{" +
                "userName='" + userName + '\'' +
                ", clientName='" + clientName + '\'' +
                '}';
    }
}
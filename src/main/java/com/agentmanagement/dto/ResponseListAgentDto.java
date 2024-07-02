package com.agentmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResponseListAgentDto {
    private int agentId;
    private String agentName;
    private String agentContactInfo;
    private Date createdAt;
}

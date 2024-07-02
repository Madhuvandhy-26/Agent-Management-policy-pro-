package com.agentmanagement.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestCreateAgentDto {
    private String agentName;
    private String agentContactInfo;
    private Date createdAt;

}

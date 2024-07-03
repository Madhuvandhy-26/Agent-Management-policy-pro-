package com.agentmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateAgentDto {
//    @NotBlank(message = "Phone Number is required")
//    @Pattern(regexp = "^(\\+91|0)?[6789]\\d{9}$",message = "Invalid Phone Number")
    private String agentContactInfo;
    private int territoryRefId;
}

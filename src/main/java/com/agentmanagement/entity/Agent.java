package com.agentmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int agentId;

    @NotBlank(message = "agentName is required")
    @Size(min = 3, message = "agentName must be more than 3 characters")
    @Column(length = 20)
    private String agentName;

    @NotBlank(message = "Phone Number is required")
    @Pattern(regexp = "^(\\+91|0)?[6789]\\d{9}$",message = "Invalid Phone Number")
    private String agentContactInfo;

}

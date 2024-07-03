package com.agentmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
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

    private Date createdAt;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL )
//    @JoinColumn(name = "territory_id", nullable = false)
    @JsonBackReference(value = "agentDetails")
    private Territory territoryRef;



}

package com.agentmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Territory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int territoryId;

    @NotBlank(message = "territoryName is required")
    @Size(min = 3,message = "territoryName must be more than 3 characters")
    private String territory_name;

}

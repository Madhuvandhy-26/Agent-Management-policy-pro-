package com.agentmanagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private String territoryName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "territoryRef")
    @JsonManagedReference(value = "agentDetails")
    private List<Agent> agents;





}

package com.agentmanagement.service;

import com.agentmanagement.dto.RequestCreateTerritroyDto;
import com.agentmanagement.dto.ResponseTerritoryDto;
import com.agentmanagement.exception.AgentException;
import org.springframework.stereotype.Service;



public interface TerritoryService {
    public abstract ResponseTerritoryDto createTerritroyService(RequestCreateTerritroyDto territoryDto) throws AgentException;
}

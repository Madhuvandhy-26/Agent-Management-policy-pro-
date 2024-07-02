package com.agentmanagement.service;

import com.agentmanagement.dto.RequestCreateAgentDto;
import com.agentmanagement.dto.ResponseAgentDto;
import com.agentmanagement.dto.ResponseListAgentDto;
import com.agentmanagement.exception.AgentException;

import java.util.List;


public interface AgentService {
    public abstract ResponseAgentDto createAgentService(RequestCreateAgentDto agent) throws AgentException;

    public abstract List<ResponseListAgentDto> getAllAgentService() throws AgentException;
}

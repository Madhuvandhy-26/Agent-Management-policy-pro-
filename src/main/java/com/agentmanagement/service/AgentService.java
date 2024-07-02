package com.agentmanagement.service;

import com.agentmanagement.dto.RequestCreateAgentDto;
import com.agentmanagement.dto.ResponseAgentDto;
import com.agentmanagement.exception.AgentException;


public interface AgentService {
    public abstract ResponseAgentDto createAgentService(RequestCreateAgentDto agent) throws AgentException;
}

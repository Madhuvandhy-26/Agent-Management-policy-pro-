package com.agentmanagement.service;

import com.agentmanagement.dto.*;
import com.agentmanagement.entity.Agent;
import com.agentmanagement.exception.AgentException;

import java.util.List;


public interface AgentService {
    public abstract ResponseAgentDto createAgentService(RequestCreateAgentDto agent) throws AgentException;

    public abstract List<ResponseListAgentDto> getAllAgentService() throws AgentException;

    public abstract ResponseDataAgentDto getAgentByIdService(int agentId) throws AgentException;

    public abstract ResponseAgentDto updateAgentService(int agentId , RequestUpdateAgentDto updateAgentDto) throws AgentException;

    public abstract ResponseAgentDto deleteAgentService(int agentId) throws AgentException;
}

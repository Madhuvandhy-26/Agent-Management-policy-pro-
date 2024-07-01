package com.agentmanagement.service;

import com.agentmanagement.dto.RequestCreateAgentDto;
import com.agentmanagement.dto.ResponseAgentDto;
import com.agentmanagement.entity.Agent;
import com.agentmanagement.exception.AgentException;
import com.agentmanagement.repo.AgentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {
    @Autowired
    private AgentRepo agentRepo;

    Date currentDate = new Date();

    @Override
    public ResponseAgentDto createAgentService(RequestCreateAgentDto agent) throws AgentException {
        String getAgentLoginValue = null;
        List<Agent> checkAgentInfo = agentRepo.findAll();
        Agent agentEntity = new Agent();

        boolean isPhoneNumberDuplicate = checkAgentInfo.stream()
                .anyMatch(agentStream -> agentStream.getAgentContactInfo().equals(agent.getAgentContactInfo()));
        if (isPhoneNumberDuplicate) {
            throw new AgentException("The PhoneNumber already exists");
        } else {
            ResponseAgentDto response = new ResponseAgentDto();
            if (agent != null) {
                agentEntity.setAgentName(agent.getAgentName());
                agentEntity.setAgentContactInfo(agent.getAgentContactInfo());
                agentEntity.setCreatedAt(currentDate);

                Agent saveAgent = agentRepo.save(agentEntity);

                response.setAgentName(agentEntity.getAgentName());
                response.setMessage("Agent Added Successfully");
            } else {
                throw new AgentException("Enter Proper Details");
            }
            return response;
        }
    }
}

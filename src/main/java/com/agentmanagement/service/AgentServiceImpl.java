package com.agentmanagement.service;

import com.agentmanagement.dto.RequestCreateAgentDto;
import com.agentmanagement.dto.ResponseAgentDto;
import com.agentmanagement.dto.ResponseListAgentDto;
import com.agentmanagement.entity.Agent;
import com.agentmanagement.exception.AgentException;
import com.agentmanagement.repo.AgentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class AgentServiceImpl implements AgentService {
    @Autowired
    private AgentRepo agentRepo;

    @Autowired
    private ModelMapper modelMapper;

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

    @Override
    public List<ResponseListAgentDto> getAllAgentService() throws AgentException {
        List<Agent> agents = agentRepo.findAll();
        List<ResponseListAgentDto> responseListAgentDtos =agents.stream().map(agent -> modelMapper.map(agent, ResponseListAgentDto.class))
                                            .collect(Collectors.toList());

        return responseListAgentDtos;
    }

}

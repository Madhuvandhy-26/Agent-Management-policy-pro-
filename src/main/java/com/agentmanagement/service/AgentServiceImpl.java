package com.agentmanagement.service;

import com.agentmanagement.dto.*;
import com.agentmanagement.entity.Agent;
import com.agentmanagement.exception.AgentException;
import com.agentmanagement.repo.AgentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;
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

    @Override
    public ResponseDataAgentDto getAgentByIdService(int agentId) throws AgentException {
        Optional<Agent> agentById = agentRepo.findById(agentId);
        ResponseDataAgentDto responseDataAgentDto = new ResponseDataAgentDto();
        if(agentById.isPresent()){
            responseDataAgentDto =modelMapper.map( agentById, ResponseDataAgentDto.class);
        }else{
            throw new AgentException("Please Enter the valid ID");
        }

        return responseDataAgentDto;
    }

    @Override
    public ResponseAgentDto updateAgentService(int agentId, RequestUpdateAgentDto updateAgentDto) throws AgentException {
        Agent agent = agentRepo.findById(agentId)
                .orElseThrow(() -> new AgentException("Agent not found"));

        agent.setAgentContactInfo(updateAgentDto.getAgentContactInfo());
        agentRepo.save(agent);
        ResponseAgentDto response = new ResponseAgentDto();
        response.setAgentName(agent.getAgentName());
        response.setMessage("Updated successfully");
        return response;
    }

    @Override
    public ResponseAgentDto deleteAgentService(int agentId) throws AgentException {
        Agent existingAgent = agentRepo.findById(agentId).get();
        ResponseAgentDto response = new ResponseAgentDto();
        if(existingAgent != null){
           agentRepo.deleteById(existingAgent.getAgentId());
           response.setAgentName(existingAgent.getAgentName());
           response.setMessage("Agent has been Deleted successfully");
           return response;

        }else {
            throw new AgentException("Agent is not found");
        }

    }

}

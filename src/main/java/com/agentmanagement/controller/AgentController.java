package com.agentmanagement.controller;

import com.agentmanagement.dto.RequestCreateAgentDto;
import com.agentmanagement.dto.ResponseAgentDto;
import com.agentmanagement.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agent")
public class AgentController {
    @Autowired
    private AgentService agentService;

    @PostMapping("/create")
    public ResponseEntity<ResponseAgentDto> createNewAgent(@RequestBody RequestCreateAgentDto agent){
       ResponseAgentDto responseAgentDto = agentService.createAgentService(agent);
       return new ResponseEntity<>(responseAgentDto, HttpStatus.CREATED);
    }
}

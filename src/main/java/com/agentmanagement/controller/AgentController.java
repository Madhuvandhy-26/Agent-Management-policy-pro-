package com.agentmanagement.controller;

import com.agentmanagement.dto.RequestCreateAgentDto;
import com.agentmanagement.dto.ResponseAgentDto;
import com.agentmanagement.dto.ResponseListAgentDto;
import com.agentmanagement.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getAll")
    public ResponseEntity<List<ResponseListAgentDto>> getAllAgent(){
        List<ResponseListAgentDto> responseListAgentDtos  = agentService.getAllAgentService();
        return new ResponseEntity<>(responseListAgentDtos,HttpStatus.OK);

    }
}

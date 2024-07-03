package com.agentmanagement.controller;

import com.agentmanagement.dto.*;
import com.agentmanagement.entity.Agent;
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

    @GetMapping("/getAllAgent")
    public ResponseEntity<List<ResponseListAgentDto>> getAllAgent(){
        List<ResponseListAgentDto> responseListAgentDtos  = agentService.getAllAgentService();
        return new ResponseEntity<>(responseListAgentDtos,HttpStatus.OK);

    }

    @GetMapping("/getAgentById/{agentId}")
    public ResponseEntity<ResponseDataAgentDto> getAgentById(@PathVariable int agentId){
        ResponseDataAgentDto agentByIdService = agentService.getAgentByIdService(agentId);
        return new ResponseEntity<>(agentByIdService,HttpStatus.OK);
    }

    @PutMapping("/updateAgent/{agentId}")
    public ResponseEntity<ResponseAgentDto> updateAgent(@PathVariable int agentId  , @RequestBody RequestUpdateAgentDto updateAgentDto){
        ResponseAgentDto responseAgentDto = agentService.updateAgentService(agentId,updateAgentDto);
        return new ResponseEntity<>(responseAgentDto,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{agentId}")
    public ResponseEntity<ResponseAgentDto>  deleteAgent(@PathVariable int agentId){
        ResponseAgentDto responseAgentDto = agentService.deleteAgentService(agentId);
        return new ResponseEntity<>(responseAgentDto,HttpStatus.ACCEPTED);
    }


}

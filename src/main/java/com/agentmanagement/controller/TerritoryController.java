package com.agentmanagement.controller;

import com.agentmanagement.dto.RequestCreateTerritroyDto;
import com.agentmanagement.dto.ResponseTerritoryDto;
import com.agentmanagement.service.TerritoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Territory")

public class TerritoryController {
    @Autowired
    private TerritoryService territoryService;

    @PostMapping("/create")
    public ResponseEntity<ResponseTerritoryDto>  createTerritory(@RequestBody RequestCreateTerritroyDto territroyDto){
        ResponseTerritoryDto territroyService = territoryService.createTerritroyService(territroyDto);
        return new ResponseEntity<>(territroyService, HttpStatus.CREATED);
    }
}

package com.agentmanagement.service;

import com.agentmanagement.dto.RequestCreateTerritroyDto;
import com.agentmanagement.dto.ResponseTerritoryDto;
import com.agentmanagement.entity.Territory;
import com.agentmanagement.exception.AgentException;
import com.agentmanagement.repo.TerritoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerritoryServiceImpl implements TerritoryService{
    @Autowired
    private TerritoryRepo territoryRepo;

    @Override
    public ResponseTerritoryDto createTerritroyService(RequestCreateTerritroyDto responseTerritoryDto) throws AgentException {
        String getTerritoryValue = null;
        List<Territory> territories = territoryRepo.findAll();
        Territory territoryEntity = new Territory();

        boolean isTerritoryDuplicate = territories.stream()
                .anyMatch(territoryStream -> territoryStream.getTerritoryName().equals(responseTerritoryDto.getTerritoryName()));
        if(isTerritoryDuplicate) {
            throw new AgentException("The Territory Name is alreay exists");

        }else {
            ResponseTerritoryDto dto = new ResponseTerritoryDto();
            if(responseTerritoryDto != null){
                territoryEntity.setTerritoryName(responseTerritoryDto.getTerritoryName());
                territoryRepo.save(territoryEntity);
                dto.setTerritoryName(territoryEntity.getTerritoryName());
                dto.setMessage("Territory Added Successfully");
            }else {
                throw  new AgentException("Enter Proper Details");
            }
            return dto;
        }

    }
}

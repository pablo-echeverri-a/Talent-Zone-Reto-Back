package com.co.sofka.talentzone.backend.reto.tourfrancia.services;

import com.co.sofka.talentzone.backend.reto.tourfrancia.models.dtos.CyclistDTO;
import com.co.sofka.talentzone.backend.reto.tourfrancia.models.entities.Cyclist;
import com.co.sofka.talentzone.backend.reto.tourfrancia.repositories.CyclistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CyclistServiceImpl implements CyclistService{

    @Autowired
    private CyclistRepository cyclistRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CyclistDTO> findAllCyclists() {
        List<CyclistDTO> cyclists = new ArrayList<>();
        cyclistRepository.findAll().forEach(cyclist -> {
            CyclistDTO cyclistDTO = modelMapper.map(cyclist, CyclistDTO.class);
            cyclists.add(cyclistDTO);
        });
        return cyclists;
    }

    @Override
    public CyclistDTO saveNewCyclist(CyclistDTO cyclist) {
        Cyclist newCyclist = modelMapper.map(cyclist, Cyclist.class);
        return modelMapper.map(cyclistRepository.save(newCyclist), CyclistDTO.class);
    }

    @Override
    public CyclistDTO findCyclistByCompetitorNumber(String competitorNumber) {
        CyclistDTO cyclistDTO = modelMapper.map(cyclistRepository.findCyclistByCompetitorNumber(competitorNumber), CyclistDTO.class);
        return cyclistDTO;
    }

    @Override
    public List<CyclistDTO> findCyclistsByTeamCode(String teamCode) {
        List<CyclistDTO> cyclists = new ArrayList<>();
        cyclistRepository.findByCyclingTeamTeamCode(teamCode).forEach(cyclist -> {
            CyclistDTO cyclistDTO = modelMapper.map(cyclist, CyclistDTO.class);
            cyclists.add(cyclistDTO);
        });
        return cyclists;
    }
}

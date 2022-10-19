package com.co.sofka.talentzone.backend.reto.tourfrancia.services;

import com.co.sofka.talentzone.backend.reto.tourfrancia.models.dtos.CyclingTeamDTO;
import com.co.sofka.talentzone.backend.reto.tourfrancia.models.entities.CyclingTeam;
import com.co.sofka.talentzone.backend.reto.tourfrancia.repositories.CyclingTeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CyclingTeamServiceImpl implements CyclingTeamService{

    @Autowired
    private CyclingTeamRepository cyclingTeamRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CyclingTeamDTO> findAllCyclingTeams() {
        List<CyclingTeamDTO> teams = new ArrayList<>();
        cyclingTeamRepository.findAll().forEach(cyclingTeam -> {
            CyclingTeamDTO cyclingTeamDTO = modelMapper.map(cyclingTeam, CyclingTeamDTO.class);
            teams.add(cyclingTeamDTO);
        });
        return teams;
    }

    @Override
    public CyclingTeamDTO saveCyclingTeam(CyclingTeamDTO cyclingTeam) {
        CyclingTeam newCyclingTeam = modelMapper.map(cyclingTeam, CyclingTeam.class);
        return modelMapper.map(cyclingTeamRepository.save(newCyclingTeam), CyclingTeamDTO.class);
    }

    @Override
    public CyclingTeamDTO findCyclingTeamByCode(String teamCode) {
        CyclingTeamDTO cyclingTeamDTO = modelMapper.map(cyclingTeamRepository.findCyclingTeamByTeamCode(teamCode), CyclingTeamDTO.class);
        return cyclingTeamDTO;
    }
}

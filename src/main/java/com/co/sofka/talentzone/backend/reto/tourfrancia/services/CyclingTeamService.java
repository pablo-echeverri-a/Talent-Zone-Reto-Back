package com.co.sofka.talentzone.backend.reto.tourfrancia.services;

import com.co.sofka.talentzone.backend.reto.tourfrancia.models.dtos.CyclingTeamDTO;

import java.util.List;

public interface CyclingTeamService {

    public List<CyclingTeamDTO> findAllCyclingTeams();

    public CyclingTeamDTO saveCyclingTeam(CyclingTeamDTO cyclingTeam);

    public CyclingTeamDTO findCyclingTeamByCode(String teamCode);
}

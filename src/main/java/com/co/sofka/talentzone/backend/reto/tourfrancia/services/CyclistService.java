package com.co.sofka.talentzone.backend.reto.tourfrancia.services;

import com.co.sofka.talentzone.backend.reto.tourfrancia.models.dtos.CyclistDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CyclistService {
    public List<CyclistDTO> findAllCyclists();

    public CyclistDTO saveNewCyclist(CyclistDTO newCyclist);

    public CyclistDTO findCyclistByCompetitorNumber(String competitorNumber);

    public List<CyclistDTO> findCyclistsByTeamCode(String teamCode);
}

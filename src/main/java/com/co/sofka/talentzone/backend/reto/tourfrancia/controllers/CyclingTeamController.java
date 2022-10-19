package com.co.sofka.talentzone.backend.reto.tourfrancia.controllers;

import com.co.sofka.talentzone.backend.reto.tourfrancia.models.dtos.CyclingTeamDTO;
import com.co.sofka.talentzone.backend.reto.tourfrancia.services.CyclingTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cycling-teams")
public class CyclingTeamController {

    @Autowired
    private CyclingTeamService service;

    @GetMapping("/teams")
    public ResponseEntity<List<CyclingTeamDTO>> findAllCyclingTeams() {
        List<CyclingTeamDTO> teams = service.findAllCyclingTeams();
        return ResponseEntity.ok().body(teams);
    }

    @PostMapping("/newTeam")
    public ResponseEntity<CyclingTeamDTO> saveCyclingTeam(@Validated @RequestBody CyclingTeamDTO cyclingTeam) {
        CyclingTeamDTO newCyclingTeam = service.saveCyclingTeam(cyclingTeam);
        return ResponseEntity.created(URI.create("/api/cycling-teams/newTeam/".concat(String.valueOf(newCyclingTeam.getId())))).body(newCyclingTeam);
    }
}

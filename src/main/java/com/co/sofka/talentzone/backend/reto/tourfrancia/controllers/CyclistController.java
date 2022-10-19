package com.co.sofka.talentzone.backend.reto.tourfrancia.controllers;

import com.co.sofka.talentzone.backend.reto.tourfrancia.models.dtos.CyclistDTO;
import com.co.sofka.talentzone.backend.reto.tourfrancia.services.CyclistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cyclist")
public class CyclistController {

    @Autowired
    private CyclistService service;

    @GetMapping("/cyclists")
    public ResponseEntity<List<CyclistDTO>> findAllCyclists(){
        List<CyclistDTO> cyclists = service.findAllCyclists();
        return ResponseEntity.ok().body(cyclists);
    }

    @PostMapping("/newCyclist")
    public ResponseEntity<CyclistDTO> saveNewCyclist(@Validated @RequestBody CyclistDTO newCyclist) {
        CyclistDTO cyclistDTO = service.saveNewCyclist(newCyclist);
        return ResponseEntity.created(URI.create("/api/cyclist/newCyclist/".concat(String.valueOf(cyclistDTO.getId())))).body(cyclistDTO);
    }

    @GetMapping("/{competitorNumber}")
    public ResponseEntity<CyclistDTO> findCyclistByCompetitorNumber(
            @PathVariable(name = "competitorNumber") String competitorNumber) {
        try {
            return ResponseEntity.ok().body(service.findCyclistByCompetitorNumber(competitorNumber));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/team/{teamCode}")
    public ResponseEntity<List<CyclistDTO>> findCyclistByTeamCode(
            @PathVariable(name = "teamCode") String teamCode) {
        try {
            return ResponseEntity.ok().body(service.findCyclistsByTeamCode(teamCode));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}

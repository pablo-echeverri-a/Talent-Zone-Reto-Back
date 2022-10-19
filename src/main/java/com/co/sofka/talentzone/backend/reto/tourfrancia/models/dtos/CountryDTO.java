package com.co.sofka.talentzone.backend.reto.tourfrancia.models.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CountryDTO {

    private int id;

    private String name;

    private String code;

    private List<CyclingTeamDTO> cyclingTeams;

    private List<CyclistDTO> cyclists;
}

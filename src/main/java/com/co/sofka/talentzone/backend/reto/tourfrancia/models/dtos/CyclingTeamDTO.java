package com.co.sofka.talentzone.backend.reto.tourfrancia.models.dtos;

import com.co.sofka.talentzone.backend.reto.tourfrancia.models.entities.Country;
import lombok.Data;

import java.util.List;

@Data
public class CyclingTeamDTO {

    private int id;

    private String name;

    private String teamCode;

    private Country country;

    private List<CyclistDTO> cyclists;
}

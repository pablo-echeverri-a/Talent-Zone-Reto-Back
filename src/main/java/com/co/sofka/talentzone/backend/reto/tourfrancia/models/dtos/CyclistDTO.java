package com.co.sofka.talentzone.backend.reto.tourfrancia.models.dtos;

import com.co.sofka.talentzone.backend.reto.tourfrancia.models.entities.Country;
import com.co.sofka.talentzone.backend.reto.tourfrancia.models.entities.CyclingTeam;
import lombok.Data;

@Data
public class CyclistDTO {

    private int id;

    private String fullName;

    private String competitorNumber;

    private Country country;

    private CyclingTeam cyclingTeam;
}

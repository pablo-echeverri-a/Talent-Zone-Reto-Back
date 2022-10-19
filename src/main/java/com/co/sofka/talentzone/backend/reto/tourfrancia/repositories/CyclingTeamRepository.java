package com.co.sofka.talentzone.backend.reto.tourfrancia.repositories;

import java.util.Optional;


import com.co.sofka.talentzone.backend.reto.tourfrancia.models.entities.CyclingTeam;
import org.springframework.data.repository.CrudRepository;

public interface CyclingTeamRepository extends CrudRepository<CyclingTeam, Integer> {
	public Optional<CyclingTeam> findCyclingTeamByTeamCode(String teamCode);
}

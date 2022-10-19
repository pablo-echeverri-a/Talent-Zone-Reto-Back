package com.co.sofka.talentzone.backend.reto.tourfrancia.repositories;

import java.util.List;
import java.util.Optional;

import com.co.sofka.talentzone.backend.reto.tourfrancia.models.entities.Cyclist;
import org.springframework.data.repository.CrudRepository;

public interface CyclistRepository extends CrudRepository<Cyclist, Integer> {
	public Optional<Cyclist> findCyclistByCompetitorNumber(String competitorNumber);
	public List<Cyclist> findByCyclingTeamTeamCode(String teamCode); 
}

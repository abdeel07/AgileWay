package com.stdev.AgileWay.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stdev.AgileWay.entities.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

	Optional<Team> findByTeamNameContainingIgnoreCase(String TeamName);
}

package com.mission.app.dao;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mission.app.entities.Mission;


@Repository
public interface MissionRepo extends JpaRepository<Mission, String> {
	Mission findMissionById(String id);
	Collection<Mission> findByProfUsername(String profUsername);
	Collection<Mission> findByStatut(boolean statut);
}

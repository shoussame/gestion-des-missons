package com.mission.app.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mission.app.entities.Professeur;


@Repository
public interface ProfesseurRepo extends JpaRepository<Professeur, String> {
	Professeur findByUsername(String username);
	Professeur getProfesseurById(String id);
	Professeur findProfesseurById(String id);
}

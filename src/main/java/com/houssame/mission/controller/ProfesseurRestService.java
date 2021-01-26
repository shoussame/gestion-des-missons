package com.houssame.mission.controller;

import java.util.Collection;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.houssame.mission.dao.MissionRepo;
import com.houssame.mission.dao.ProfesseurRepo;
import com.houssame.mission.entities.Mission;
import com.houssame.mission.entities.Professeur;




@RestController
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class ProfesseurRestService {
	private ProfesseurRepo profRepo;
	private MissionRepo missionRestClient;

	public ProfesseurRestService(ProfesseurRepo profRepo,MissionRepo missionRestClient) {
		super();
		this.profRepo = profRepo;
		this.missionRestClient = missionRestClient;
	}
	@GetMapping("/professeurs")
	@RolesAllowed({"ADMIN","MODERATOR","PROFESSEUR"})
	public List<Professeur> getProfesseus(){
			return profRepo.findAll();
	        }
	@GetMapping("/professeurs/{username}")
	@RolesAllowed({"ADMIN","MODERATOR","PROFESSEUR"})
	public Professeur getProfesseurByUsername(@PathVariable(name="username") String username){
			Collection<Mission> missions = missionRestClient.findByProfUsername(username);
			Professeur prof = profRepo.findByUsername(username);
			prof.setMissions(missions);
			return prof;
	        }
	@GetMapping("/professeur")
	@RolesAllowed({"USER"})
	public Professeur getProfByUsername(@RequestBody String username){
			Collection<Mission> missions = missionRestClient.findByProfUsername(username);
			Professeur prof = profRepo.findByUsername(username);
			prof.setMissions(missions);
			return prof;
	        }
	@GetMapping("/professeur/{id}")
	@RolesAllowed({"ADMIN","MODERATOR","PROFESSEUR"})
	public Professeur getProfesseurById(@PathVariable(name="id") String id){
		Professeur prof = profRepo.findProfesseurById(id);
			Collection<Mission> missions = missionRestClient.findByProfUsername(prof.getUsername());
			prof.setMissions(missions);
			return prof;
	        }
	/*
	@GetMapping("/personnes/missions/{id}")
	public Professeur getProfesseurMission(@PathVariable(name="username") String username){
			Professeur prof=profRepo.findByUsername(username);
	        prof.getMissions().add((Mission) missionRestClient.findByProfesseurUsername(prof.getUsername()));
	        prof.getMissions().forEach(a -> prof.getMissions().add(a) );
	        return prof;
	        }
	        */
}

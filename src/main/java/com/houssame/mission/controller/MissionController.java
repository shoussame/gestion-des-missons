package com.houssame.mission.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.houssame.mission.dao.MissionRepo;
import com.houssame.mission.dao.ProfesseurRepo;
import com.houssame.mission.entities.Mission;
import com.houssame.mission.entities.Professeur;

@RestController
@CrossOrigin("http://localhost:8080")
public class MissionController {
	private MissionRepo missionRepo;
	private ProfesseurRepo client;
	 public MissionController(MissionRepo missionRepo, ProfesseurRepo client) {
		super();
		this.missionRepo = missionRepo;
		this.client = client;
	}
	
	    @GetMapping("/missions/profUsername/{username}")
	    Collection<Mission> getMissions(@PathVariable(name="username") String username){
	    	Professeur prof = client.findByUsername(username);
	        Collection<Mission> mission = missionRepo.findByProfUsername(prof.getUsername());
	        return mission;
}
	    @GetMapping("/missions")
		  List<Mission> all() {
		    return missionRepo.findAll();
		  }

		  @PostMapping("/missions/add")
		  @RolesAllowed({"ADMIN","MODERATOR","PROFESSEUR"})
		  Mission newMission(@RequestBody Mission mission) {
			  Professeur prof = client.findByUsername(mission.getProfUsername());
			  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();
			   mission.setProfesseur(prof);
			  mission.setDateDemande(dtf.format(now));
		    return missionRepo.save(mission);
		  }

		  // Single item

		  @PostMapping("/missions/{id}")
		  Mission one(@PathVariable String id) throws Exception {
			  
		    return missionRepo.getOne(id);
		  }
		  @PostMapping("/missions/delete/{id}")
		  @RolesAllowed({"ADMIN","MODERATOR"})
		  void deleteMission(@PathVariable String id) {
		    missionRepo.deleteById(id);
		  }
		  @PostMapping("/missions/update")
		  Mission replaceMission(@RequestBody Mission missionn) {

		    return missionRepo.findById(missionn.getId())
		      .map(mission -> {
		    	mission.setId(missionn.getId());
		        mission.setDateDepart(missionn.getDateDepart());
		        mission.setDateRetour(missionn.getDateRetour());
		        mission.setVille(missionn.getVille());
		        mission.setStatut(missionn.isStatut());
		        return missionRepo.save(mission);
		      })
		      .orElseGet(() -> {
		        missionn.setId(missionn.getId());
		        return missionRepo.save(missionn);
		      });
		  }
		  @PostMapping("missions/statut")
		  Collection<Mission> findByStatut(boolean staut){
			  return missionRepo.findByStatut(staut);
		  }
}

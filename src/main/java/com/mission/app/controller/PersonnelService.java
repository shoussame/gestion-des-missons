package com.mission.app.controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mission.app.dao.AppUserRepo;
import com.mission.app.entities.AppUser;
import com.mission.app.entities.Mission;


@RestController
@CrossOrigin("http://localhost:8080")
public class PersonnelService {
	private AppUserRepo userRepo;

	public PersonnelService(AppUserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}
	@GetMapping("/personnes")
	public List<AppUser> getPersonnel(){
			return userRepo.findAll();
	        }
	@PostMapping("/personnes/add")
	public AppUser addPersonnel(@RequestBody AppUser appUser) {
		return userRepo.save(appUser);
	}
	 @PostMapping("/personnes/delete/{id}")
	  void deleteMission(@PathVariable String id) {
	    userRepo.deleteById(id);
	  }
	  @PostMapping("/personnes/update")
	  AppUser replaceMission(@RequestBody AppUser userr) {

	    return userRepo.findById(userr.getId())
	      .map(user -> {
	    	user.setNom(userr.getNom());
	        user.setPrenom(userr.getPrenom());
	        user.setFonction(userr.getFonction());
	        user.setDateDeNaissance(userr.getDateDeNaissance());
	        user.setUsername(userr.getUsername());
	        return userRepo.save(user);
	      })
	      .orElseGet(() -> {
	        userr.setId(userr.getId());
	        return userRepo.save(userr);
	      });
	  }
}

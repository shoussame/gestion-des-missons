package com.houssame.mission.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.houssame.mission.dao.AppUserRepo;

@RestController
@CrossOrigin("http://localhost:8080")
public class PersonnelService {
	private AppUserRepo userRepo;

	public PersonnelService(AppUserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

}

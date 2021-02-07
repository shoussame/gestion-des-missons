package com.mission.app.controller;


import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mission.app.dao.AppRoleRepo;
import com.mission.app.dao.AppUserRepo;
import com.mission.app.dao.MissionRepo;
import com.mission.app.entities.AppRole;
import com.mission.app.entities.AppUser;
import com.mission.app.entities.Mission;






@Transactional
@Service
public class AppService implements AccService{
	private AppRoleRepo appRoleRepository;
	private AppUserRepo appUserRepo;
	private MissionRepo missionRestClient;
	
	public AppService(AppRoleRepo appRoleRepository, AppUserRepo appUserRepo,
			MissionRepo missionRestClient) {
		super();
		this.appRoleRepository = appRoleRepository;
		this.appUserRepo = appUserRepo;
		this.missionRestClient = missionRestClient;
	}

	@Override
	public AppUser addUser(AppUser appUser) {
		return appUserRepo.save(appUser);
	}

	@Override
	public AppRole addRole(AppRole appRole) {
		return appRoleRepository.save(appRole);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppUser a = appUserRepo.findByUsername(username);
		AppRole b = appRoleRepository.findByRoleName(roleName);
		a.getAppRoles().add(b);
	}

	@Override
	public AppUser loadUserByUsername(String username) {
		return appUserRepo.findByUsername(username);
	}

	@Override
	public Collection<Mission> findMissionsByProfesseurUsername(String username) {
		Collection<Mission> missions = null;
		try {
			missions = missionRestClient.findByProfUsername(username);
		} catch (Exception e) {
			System.err.println(e);
		}
		return missions;
	}

	@Override
	public List<AppUser> listUsers() {
		return appUserRepo.findAll();
	}

	@Override
	public List<AppRole> listRoles() {
		return appRoleRepository.findAll();
	}

	


}

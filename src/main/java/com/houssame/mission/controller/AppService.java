package com.houssame.mission.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.houssame.mission.dao.AppRoleRepo;
import com.houssame.mission.dao.AppUserRepo;
import com.houssame.mission.dao.MissionRepo;
import com.houssame.mission.entities.AppRole;
import com.houssame.mission.entities.AppUser;
import com.houssame.mission.entities.Mission;





@Transactional
@Service
public class AppService implements AccService{
	private AppRoleRepo appRoleRepository;
	private AppUserRepo appUserRepo;
	private MissionRepo missionRestClient;
	private PasswordEncoder passwordEncoder;
	
	public AppService(AppRoleRepo appRoleRepository, AppUserRepo appUserRepo,
			MissionRepo missionRestClient, PasswordEncoder passwordEncoder) {
		super();
		this.appRoleRepository = appRoleRepository;
		this.appUserRepo = appUserRepo;
		this.missionRestClient = missionRestClient;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public AppUser addUser(AppUser appUser) {
		String pw = appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pw));
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

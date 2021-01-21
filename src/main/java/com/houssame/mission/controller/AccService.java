package com.houssame.mission.controller;

import java.util.Collection;
import java.util.List;

import com.houssame.mission.entities.AppRole;
import com.houssame.mission.entities.AppUser;
import com.houssame.mission.entities.Mission;




public interface AccService {
	AppUser addUser(AppUser appUser);
	AppRole addRole(AppRole approle);
	void addRoleToUser(String username, String roleName);
	AppUser loadUserByUsername(String username);
	Collection<Mission> findMissionsByProfesseurUsername(String username);
	List<AppUser> listUsers();
	List<AppRole> listRoles();
}

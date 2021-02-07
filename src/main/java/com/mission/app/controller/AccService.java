package com.mission.app.controller;


import java.util.Collection;
import java.util.List;

import com.mission.app.entities.AppRole;
import com.mission.app.entities.AppUser;
import com.mission.app.entities.Mission;





public interface AccService {
	AppUser addUser(AppUser appUser);
	AppRole addRole(AppRole approle);
	void addRoleToUser(String username, String roleName);
	AppUser loadUserByUsername(String username);
	Collection<Mission> findMissionsByProfesseurUsername(String username);
	List<AppUser> listUsers();
	List<AppRole> listRoles();
}

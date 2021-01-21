package com.houssame.mission.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.houssame.mission.entities.AppRole;

@Repository
public interface AppRoleRepo extends JpaRepository<AppRole, String>{
	AppRole findByRoleName(String roleName);
}

package com.mission.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mission.app.entities.AppRole;


@Repository
public interface AppRoleRepo extends JpaRepository<AppRole, String>{
	AppRole findByRoleName(String roleName);
}

package com.mission.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mission.app.entities.AppUser;


@Repository
public interface AppUserRepo extends JpaRepository<AppUser, String>{
	AppUser findByUsername(String username);
}

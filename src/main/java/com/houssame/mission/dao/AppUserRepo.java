package com.houssame.mission.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.houssame.mission.entities.AppUser;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, String>{
	AppUser findByUsername(String username);
}

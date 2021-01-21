package com.houssame.mission.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.houssame.mission.entities.FileDb;

@Repository
public interface FileDbRepo extends JpaRepository<FileDb, String> {

}

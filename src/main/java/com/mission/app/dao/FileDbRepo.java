package com.mission.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mission.app.entities.FileDb;


@Repository
public interface FileDbRepo extends JpaRepository<FileDb, String> {

}

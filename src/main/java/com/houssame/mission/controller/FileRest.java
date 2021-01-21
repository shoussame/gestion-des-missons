package com.houssame.mission.controller;



import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.houssame.mission.dao.FileDbRepo;
import com.houssame.mission.entities.FileDb;
;

@RestController
public class FileRest {
	@Autowired
	private FileDbRepo fileRepo;
	
	public FileDb store(MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    FileDb FileDB = new FileDb(fileName, file.getContentType(), file.getBytes());

	    return fileRepo.save(FileDB);
	  }

	  public FileDb getFile(String id) {
	    return fileRepo.findById(id).get();
	  }
	  
	  public Stream<FileDb> getAllFiles() {
	    return fileRepo.findAll().stream();
	  }
}

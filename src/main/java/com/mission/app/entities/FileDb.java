package com.mission.app.entities;




import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity @AllArgsConstructor @NoArgsConstructor
public class FileDb {
	 @Id
	 @GeneratedValue(generator = "uuid")
	 @GenericGenerator(name = "uuid", strategy = "uuid2")
	 private String id;
	 private String name;
	 private String type;
	 @ManyToOne(cascade = CascadeType.ALL)
	 private Mission mission;
	 private byte[] data;
	 public FileDb(String name, String type, byte[] data) {
			super();
			this.name = name;
			this.type = type;
			this.data = data;
		}
}

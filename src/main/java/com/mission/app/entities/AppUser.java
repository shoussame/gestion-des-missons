package com.mission.app.entities;


import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class AppUser {
	@Id @GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String username;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private String nom;
	private String prenom;
	private String email;
	private String DateDeNaissance;
	private String fonction;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<AppRole> appRoles;
	public AppUser(String username, String password, String nom, String prenom, String email, String dateDeNaissance) {
		super();
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.DateDeNaissance = dateDeNaissance;
	}
	public AppUser(String username, String password, String nom, String prenom, String email, String dateDeNaissance,
			String fonction) {
		super();
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.DateDeNaissance = dateDeNaissance;
		this.fonction = fonction;
	}
	
}

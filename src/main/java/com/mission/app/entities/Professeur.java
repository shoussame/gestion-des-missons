package com.mission.app.entities;




import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity @AllArgsConstructor @NoArgsConstructor
public class Professeur extends AppUser{
	@JsonIgnore
	@OneToMany(mappedBy = "professeur",fetch = FetchType.LAZY)
	private Collection<Mission> missions;
	
	public Professeur(String username, String password, String nom, String prenom, String email,
			String dateDeNaissance) {
		super(username, password, nom, prenom, email, dateDeNaissance);
	}

	public Collection<Mission> getMissions() {
		return missions;
	}

	public void setMissions(Collection<Mission> missions) {
		this.missions = missions;
	}
	public Professeur(String username, String password, String nom, String prenom, String email,
			String dateDeNaissance,String fonction) {
		super(username, password, nom, prenom, email, dateDeNaissance,fonction);
	}
	
}

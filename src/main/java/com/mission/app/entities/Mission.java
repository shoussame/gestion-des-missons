package com.mission.app.entities;




import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @Entity @AllArgsConstructor @NoArgsConstructor
public class Mission {
	@Id @GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String dateDemande;
	private String dateDepart;
	private String dateRetour;
	private String statutActuel;
	private boolean validationDirecteur;
	private boolean validationDirectAdj;
	private boolean validationComptable;
	private String profUsername;
	@ManyToOne
	@JoinColumn(name = "prof_id")
	private Professeur professeur;
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "mission")
	private Collection<FileDb> files = new ArrayList<>();
	private String ville;
	private boolean statut;
	
	private String motif;
	private long budget;
	public Mission(String dateDepart, String dateRetour, Professeur professeur) {
		super();
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.professeur = professeur;
	}
	
}

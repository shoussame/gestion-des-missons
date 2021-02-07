package com.mission.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mission.app.controller.AppService;
import com.mission.app.dao.AppRoleRepo;
import com.mission.app.dao.MissionRepo;
import com.mission.app.dao.ProfesseurRepo;
import com.mission.app.entities.*;

@SpringBootApplication
public class MissionBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MissionBackApplication.class, args);
	}
	@Bean
	CommandLineRunner start(AppRoleRepo roleRepo,AppService accService,
			ProfesseurRepo professeurRepo , MissionRepo missionRepo) {
		return args -> {
			accService.addUser(new AppUser("SofiaA", "sofiaPass", "AG", "Sofia", "sofia@gmail.com", "10/5/92","SECRETAIRE"));
			accService.addUser(new AppUser("RedaQ", "redaPass", "QABLI", "Reda", "reda@gmail.com", "10/5/92","DIRECTEUR_ADJ"));
			accService.addUser(new AppUser("AbdoM", "abdoPass", "MOUDINE", "Abderrahmane", "abdo@gmail.com", "10/5/92","COMPTABLE"));
			accService.addUser(new AppUser("OussamaC", "oussPassword", "CHIHABI", "Oussama", "oussama@gmail.com", "10/5/92","DIRECTEUR"));
			
			roleRepo.save(new AppRole("ADMIN"));
			roleRepo.save(new AppRole("USER"));
			roleRepo.save(new AppRole("MODERATOR"));
			roleRepo.save(new AppRole("PROFESSEUR"));
			
			accService.addRoleToUser("SofiaA", "MODERATOR");
			accService.addRoleToUser("SofiaA", "ADMIN");
			accService.addRoleToUser("SofiaA", "USER");
			
			accService.addRoleToUser("RedaQ", "MODERATOR");
			accService.addRoleToUser("RedaQ", "USER");
			
			accService.addRoleToUser("AbdoM", "MODERATOR");
			accService.addRoleToUser("AbdoM", "USER");
			
			accService.addRoleToUser("OussamaC", "MODERATOR");
			accService.addRoleToUser("OussamaC", "ADMIN");
			accService.addRoleToUser("OussamaC", "USER");
			
			professeurRepo.save(new Professeur("HamzaY", "hamzaPass", "YOUSFI", "Hamza", "hamza@gmail.com", "08/13/96","PROFESSEUR"));
			professeurRepo.save(new Professeur("HichamK", "hichamPass", "KOUHAIL", "Hicham", "hicham@gmail.com", "08/13/96","PROFESSEUR"));
			professeurRepo.save(new Professeur("AyoubT", "ayoubPass", "TAOUFIK", "Ayoub", "ayoub@gmail.com", "08/13/96","PROFESSEUR"));
			
			accService.addRoleToUser("HamzaY", "USER");
			accService.addRoleToUser("HamzaY", "PROFESSEUR");
			accService.addRoleToUser("HichamK", "USER");
			accService.addRoleToUser("HichamK", "PROFESSEUR");
			accService.addRoleToUser("AyoubT", "USER");
			accService.addRoleToUser("AyoubT", "PROFESSEUR");
			
			missionRepo.save(new Mission("2019-11-01", "2020-01-01", professeurRepo.findByUsername("HamzaY")));
			missionRepo.save(new Mission("2020-01-01", "2020-02-01", professeurRepo.findByUsername("HichamK")));
			missionRepo.save(new Mission("2020-02-01", "2020-03-01", professeurRepo.findByUsername("AyoubT")));
		};
	
}

}

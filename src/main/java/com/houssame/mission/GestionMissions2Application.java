package com.houssame.mission;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.houssame.mission.controller.AccService;
import com.houssame.mission.controller.AppService;
import com.houssame.mission.dao.AppRoleRepo;
import com.houssame.mission.dao.AppUserRepo;
import com.houssame.mission.dao.MissionRepo;
import com.houssame.mission.dao.ProfesseurRepo;
import com.houssame.mission.entities.AppRole;
import com.houssame.mission.entities.AppUser;
import com.houssame.mission.entities.Mission;
import com.houssame.mission.entities.Professeur;

@SpringBootApplication
public class GestionMissions2Application {

	public static void main(String[] args) {
		SpringApplication.run(GestionMissions2Application.class, args);
	}
	@Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	@Bean
	CommandLineRunner start(AppRoleRepo roleRepo,AccService accService,
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
			
			missionRepo.save(new Mission("01/01/01", "01/01/01", professeurRepo.findByUsername("HamzaY")));
			missionRepo.save(new Mission("01/02/01", "01/05/01", professeurRepo.findByUsername("HichamK")));
			missionRepo.save(new Mission("01/03/01", "01/06/01", professeurRepo.findByUsername("AyoubT")));
		};

}
}

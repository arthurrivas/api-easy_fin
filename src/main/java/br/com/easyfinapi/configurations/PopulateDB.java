package br.com.easyfinapi.configurations;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.easyfinapi.domains.Professor;
import br.com.easyfinapi.domains.Users;
import br.com.easyfinapi.services.ProfessorService;
import br.com.easyfinapi.services.UserServices;
@Configuration
public class PopulateDB implements CommandLineRunner {
	
	@Autowired
	UserServices userServices;
	@Autowired
	ProfessorService professorService;

	@Override
	public void run(String... args) throws Exception {		
		
		userServices.deleteAll();
		professorService.deleteAll();
		
		Professor arthur = new Professor(null,"arthur","arthurrivas1@gmail.com","1244");
		Professor perola = new Professor(null,"perola","perola@gmail.com","1244");
		Professor joao = new Professor(null,"joao","joao@gmail.com","1244");
	
	
		professorService.saveAll(Arrays.asList(arthur,perola,joao));
	
	
	}

}

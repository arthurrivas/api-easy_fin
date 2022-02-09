package br.com.easyfinapi.configurations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.easyfinapi.domains.Professor;
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
		
//		userServices.deleteAll();
//		professorService.deleteAll();
//		
//		Professor arthur = new Professor(null,"arthur","arthurrivas1@gmail.com","1244");
//		Professor perola = new Professor(null,"perola","perola@gmail.com","1244");
//		Professor joao = new Professor(null,"joao","joao@gmail.com","1244");
//	
		
//		Optional<Professor> obj = professorService.findById("61ec311f230a21462deffc18");
//		Professor prof = obj.get();
//		List<String> lista = prof.getPerfisUser().stream().map(x -> x.toString()).collect(Collectors.toList());
//		System.out.println(prof);
//		
//		System.out.print(lista);
		
//		professorService.saveAll(Arrays.asList(arthur,perola,joao));
//	
	
	}

}

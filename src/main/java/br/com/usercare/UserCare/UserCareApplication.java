package br.com.usercare.UserCare;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.usercare.model.CuidadorEntity;
import br.com.usercare.model.IdosoEntity;
import br.com.usercare.repository.CuidadorRepository;
import br.com.usercare.repository.IdosoRepository;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.usercare")
@EnableJpaRepositories(basePackages = "br.com.usercare.repository")
@EntityScan(basePackages = "br.com.usercare.model")
public class UserCareApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(UserCareApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UserCareApplication.class, args);
	}
	

	/**Inicializa o app adicionando alguns dados na tabela Pessoa*/
	@Bean
	public CommandLineRunner setup(CuidadorRepository cuidadorRepository, IdosoRepository idosoRepository) {
		return (args) -> {
			/** CUIDADOR */
			cuidadorRepository.save(new CuidadorEntity("12312312", "Diego", "(43) - 99830-5961"));
			cuidadorRepository.save(new CuidadorEntity("3213124", "Crislayne", "(43) - 99830-5961"));
			cuidadorRepository.save(new CuidadorEntity("4124512312", "Kelona(Laura Linda)", "(43) - 99830-5961"));
			cuidadorRepository.save(new CuidadorEntity("312512512", "CavacoMan", "(43) - 99830-5961"));
			logger.info("Cuidadores Gerados");
			
			
			idosoRepository.save(new IdosoEntity("Giovana", "(43) - 99830-5961", cuidadorRepository.findOne("12312312")));
			idosoRepository.save(new IdosoEntity("Giovana 2", "(43) - 99830-5962", cuidadorRepository.findOne("4124512312")));
			logger.info("Idosos Gerados");
		};
	}
}

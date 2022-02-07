package br.com.sigabem.frete;

import br.com.sigabem.frete.controller.response.CepResponse;
import br.com.sigabem.frete.controller.response.CepResponseDestino;
import br.com.sigabem.frete.model.FreteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootApplication(scanBasePackages = {"br.com.sigabem.frete"})
@Configuration
@EnableJpaRepositories(basePackages = {"br.com.sigabem.frete"})
public class SigabemfreteApplication {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SigabemfreteApplication.class, args);


	}



}

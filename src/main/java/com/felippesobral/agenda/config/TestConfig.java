package com.felippesobral.agenda.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.felippesobral.agenda.dominio.Contato;
import com.felippesobral.agenda.repository.ContatoRepository;

@Configuration
public class TestConfig implements CommandLineRunner{
	
	@Autowired 
	private ContatoRepository contatoRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		contatoRepository.deleteAll();
		
		Contato c1 = new Contato(null, "Felippe", "985854545", "felippe@gmail.com");
		Contato c2 = new Contato(null, "Hygor", "984844545", "hygor@gmail.com");
		Contato c3 = new Contato(null, "Joao", "985854848", "joao@gmail.com");
		
		contatoRepository.saveAll(Arrays.asList(c1, c2, c3));
		
	}

}

package com.felippesobral.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felippesobral.agenda.dominio.Contato;
import com.felippesobral.agenda.repository.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	public List<Contato> findAll(){
		List<Contato> list = contatoRepository.findAll();
		return list;
	}
	
	public Contato findById(Integer id) {
		Optional<Contato> obj = contatoRepository.findById(id);
		return obj.orElseThrow(()-> new RuntimeException("Contato não Existe"));
	}
	
	public void insert(Contato obj) {
		contatoRepository.save(obj);
	}
	
	public void update(Contato obj) {
		Contato newObj = findById(obj.getId());
		newObj.setNome(obj.getNome());
		newObj.setTelefone(obj.getTelefone());
		newObj.setEmail(obj.getEmail());
		contatoRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		contatoRepository.deleteById(id);
	}
	
}

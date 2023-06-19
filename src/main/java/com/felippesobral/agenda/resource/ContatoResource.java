package com.felippesobral.agenda.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felippesobral.agenda.dominio.Contato;
import com.felippesobral.agenda.service.ContatoService;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoResource {
	
	@Autowired
	private ContatoService contatoService;
	
	@GetMapping
	public ResponseEntity<List<Contato>> findAll(){
		List<Contato> list = contatoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Contato> findById(@PathVariable Integer id){
		Contato obj = contatoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Contato obj){
		contatoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Contato> update(@RequestBody Contato obj, @PathVariable Integer id){
		obj.setId(id);
		contatoService.update(obj);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		contatoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

package com.bezalel.church.church.controller;

import java.net.URI;
import java.util.List;

import org.hibernate.annotations.MetaValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bezalel.church.church.entities.Miembro;
import com.bezalel.church.church.repository.MiembroRepository;

@RestController
public class MiembroController {
	@Autowired
	MiembroRepository repository;
	
	@GetMapping("/miembros")
	List<Miembro> all() {
		return repository.findAll();
	}
	
	@PostMapping("/miembro")
	ResponseEntity<Void> createMiembro(@RequestBody Miembro miembro)
	{
		Miembro createdMiembro = repository.save(miembro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdMiembro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public ResponseEntity<Miembro> updateMiembro(@RequestBody Miembro miembro) {
		Miembro updatedMiembro = repository.save(miembro);
		return new ResponseEntity<Miembro>(updatedMiembro, HttpStatus.OK);
	}
	//alta
	//baja
	//modificacion
	//consulta unitaria
}

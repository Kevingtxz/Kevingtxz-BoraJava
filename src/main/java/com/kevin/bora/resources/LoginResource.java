package com.kevin.bora.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.bora.domain.Login;
import com.kevin.bora.dto.LoginDTO;
import com.kevin.bora.services.LoginService;

@RestController
@RequestMapping(value="/login")
public class LoginResource {
	
	@Autowired
	private LoginService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Login> find(@PathVariable Integer id) {
		Login obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody LoginDTO objDto, @PathVariable Integer id){
		service.updateFromDTO(objDto, id);
		return ResponseEntity.noContent().build();
	}	
}
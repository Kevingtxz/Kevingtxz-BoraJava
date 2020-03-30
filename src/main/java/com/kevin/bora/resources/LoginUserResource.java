package com.kevin.bora.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.bora.domain.LoginUser;
import com.kevin.bora.dto.LoginDTO;
import com.kevin.bora.services.LoginUserService;

@RestController
@RequestMapping(value="/loginuser")
public class LoginUserResource {
	
	@Autowired
	private LoginUserService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<LoginUser> find(@PathVariable Integer id) {
		LoginUser obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	/*
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody LoginUserDTO objDto){
		LoginUser obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}	
*/
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody LoginDTO objDto, @PathVariable Integer id){
		service.update(objDto, id);
		return ResponseEntity.noContent().build();
	}
		
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
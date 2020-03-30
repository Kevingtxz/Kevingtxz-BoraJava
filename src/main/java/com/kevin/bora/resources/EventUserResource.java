package com.kevin.bora.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.bora.domain.EventUser;
import com.kevin.bora.dto.EventUserDTO;
import com.kevin.bora.services.EventUserService;

@RestController
@RequestMapping(value="/eventuser")
public class EventUserResource {
	
	@Autowired
	private EventUserService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<EventUser> find(@PathVariable Integer id) {
		EventUser obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	/* 				EventUsers será necessário
	 
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody EventUserNewDTO objNewDto){
		EventUser obj = service.fromDTO(objNewDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody EventUserDTO objDto, @PathVariable Integer id){
		service.update(objDto, id);
		return ResponseEntity.noContent().build();
	}	
	/*
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	*/
}
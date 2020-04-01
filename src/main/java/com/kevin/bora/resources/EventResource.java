package com.kevin.bora.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kevin.bora.domain.Event;
import com.kevin.bora.dto.EventDTO;
import com.kevin.bora.services.EventService;

@RestController
@RequestMapping(value="/events")
public class EventResource {
	
	@Autowired
	private EventService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EventDTO>> findAll() {
		List<Event> list = service.findAll();
		List<EventDTO> listDto = list.stream().map(obj -> new EventDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Event> find(@PathVariable Integer id) {
		Event obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<EventDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="name") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Event> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<EventDTO> listDto = list.map(obj -> new EventDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
	/*
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<EventDTO>> findPage(
			@RequestParam(value="name", defaultValue="") String name, 
			@RequestParam(value="category", defaultValue="") Event category, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="name") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Event> list = service.search(name,  (category==null) ? null : category.getId(), page, linesPerPage, orderBy, direction);
		Page<EventDTO> listDto = list.map(obj -> new EventDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	*/
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody EventDTO objDto){
		Event obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@Transactional	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody EventDTO objDto, @PathVariable Integer id){
		Event obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj, id);
		return ResponseEntity.noContent().build();
	}	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}










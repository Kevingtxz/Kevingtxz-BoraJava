package com.kevin.bora.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.bora.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository repo;
	/*
	public MPEvent find( Integer id ) {
		Optional<Event> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + Event.class.getName()));
	}
		
	// To implement this after, I'll implement a search LIKE %name% and category = category
	public Page<Event> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	/*
	public Page<Event> search(String name, Integer categoryId, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findDistinctByNameContainingAndCategoriasIn(name, categoryId, pageRequest);
	}
	*/
}
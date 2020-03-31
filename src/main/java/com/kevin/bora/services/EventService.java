package com.kevin.bora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.Event;
import com.kevin.bora.dto.EventDTO;
import com.kevin.bora.repositories.EventRepository;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class EventService {

	@Autowired
	private EventRepository repo;

	public List<Event> findAll(){
		return repo.findAll();
	}
	
	public Event find( Integer id ) {
		Optional<Event> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + Event.class.getName()));
	}
	
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
	
	public Event update(Event obj) {
		Event newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public Event updateData(Event newObj, Event obj) {
		if(obj.getName() != null) {
			newObj.setName(obj.getName());
		}
		if(obj.getDate() != null) {
			newObj.setDate(obj.getDate());
		}
		if(obj.getCategory() != null) {
			newObj.setCategory(obj.getCategory());
			
		}
		if(obj.getCity() != null) {
			newObj.setCity(obj.getCity());
		}
		return newObj;
	}
	
	public Event fromDTO(EventDTO objDto) {
		return new Event(objDto.getId(), objDto.getName(), objDto.getDate(), objDto.getCategory(), objDto.getAddress(), null, objDto.getEmail());
	}
}






















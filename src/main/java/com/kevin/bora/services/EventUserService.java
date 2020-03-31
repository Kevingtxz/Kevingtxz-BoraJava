package com.kevin.bora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.EventUser;
import com.kevin.bora.domain.enums.Permission;
import com.kevin.bora.dto.EventUserDTO;
import com.kevin.bora.dto.EventUserNewDTO;
import com.kevin.bora.repositories.EventUserRepository;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class EventUserService {

	@Autowired
	private EventUserRepository repo;
	
	public EventUser find( Integer id ) {
		Optional<EventUser> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + EventUser.class.getName()));
	}
	
	public EventUser insert(EventUser obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public EventUser update(EventUserDTO objDto, Integer id) {
		EventUser newObj = find(id);
		 updataData(newObj, objDto);
		return repo.save(newObj);
	}
	/*
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("It's impossible to delete a category with events");
		}
	}
	
	public List<EventUser> findAll(){
		return repo.findAll();
	}
	
	public Page<EventUser> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	*/
	
	public EventUser fromDTO(EventUserNewDTO objDto) {
		return new EventUser(null, objDto.getPermission(), objDto.getParticipation(), objDto.getLoginUser());
	}
	
	public void updataData(EventUser obj, EventUserDTO objDto) {
		if(objDto.getParticipation() != null) {
			obj.setParticipation(objDto.getParticipation());
		}
		if(objDto.getPermission() != null) {
			obj.setPermission(objDto.getPermission());
		}
	}
}
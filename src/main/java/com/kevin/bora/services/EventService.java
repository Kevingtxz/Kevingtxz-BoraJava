package com.kevin.bora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.Category;
import com.kevin.bora.domain.Chat;
import com.kevin.bora.domain.Event;
import com.kevin.bora.domain.EventUsers;
import com.kevin.bora.domain.Neighborhood;
import com.kevin.bora.dto.EventDTO;
import com.kevin.bora.repositories.ChatRepository;
import com.kevin.bora.repositories.EventRepository;
import com.kevin.bora.repositories.EventUsersRepository;
import com.kevin.bora.services.exceptions.DataIntegrityException;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class EventService {

	@Autowired
	private ChatRepository chatRepository;
	@Autowired
	private EventRepository repo;
	@Autowired
	private EventUsersRepository eventUsersRepository;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private NeighborhoodService neighborhoodService;
	
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
	
	public Event insert(EventDTO objDto) {
		Neighborhood neighborhood = neighborhoodService.find(objDto.getNeighborhoodId());
		Category category = categoryService.find(objDto.getCategoryId());
		Chat chat = new Chat(null);
		Event event = new Event(null, objDto.getNickName(), objDto.getDate(), category, neighborhood, objDto.getEmail(), objDto.getPassword());
		EventUsers eventUsers = new EventUsers(null, event, chat);
		chatRepository.save(chat);
		repo.save(event);
		eventUsersRepository.save(eventUsers);
		return event;
	}
	
	public Event update(Event obj, Integer id) {
		Event newObj = find(id);
		return repo.save(updateData(newObj, obj));
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("It's impossible to delete a category with events");
		}
	}
	
	public Event updateData(Event newObj, Event obj) {
		if(obj.getCategory() != null) {
			newObj.setCategory(obj.getCategory());
		}
		if(obj.getCity() != null) {
			newObj.setCity(obj.getCity());
		}
		if(obj.getDate() != null) {
			newObj.setDate(obj.getDate());
		}
		if(obj.getEmail() != null) {
			newObj.setEmail(obj.getEmail());
		}
		if(obj.getNeighborhood() != null) {
			obj.setNeighborhood(obj.getNeighborhood());
		}
		if(obj.getNickName() != null) {
			newObj.setNickName(obj.getNickName());
		}
		if(obj.getPassword() != null) {
			newObj.setPassword(obj.getPassword());
		}
		return newObj;
	}
	
	public Event fromDTO(EventDTO objDto) {
		return new Event(objDto.getId(), objDto.getNickName(), objDto.getDate(), categoryService.find(objDto.getCategoryId()), neighborhoodService.find(objDto.getNeighborhoodId()), objDto.getEmail(), objDto.getPassword());
	}
}
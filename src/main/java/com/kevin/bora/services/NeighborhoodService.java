package com.kevin.bora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.Neighborhood;
import com.kevin.bora.repositories.NeighborhoodRepository;
import com.kevin.bora.services.exceptions.DataIntegrityException;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class NeighborhoodService {

	@Autowired
	private NeighborhoodRepository repo;
	
	public Neighborhood find( Integer id ) {
		Optional<Neighborhood> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + Neighborhood.class.getName()));
	}
	
	public Neighborhood insert(Neighborhood obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Neighborhood update(Neighborhood obj) {
		Neighborhood newObj = find(obj.getId());
		updataData(newObj, obj);
		return repo.save(newObj);
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
	
	public List<Neighborhood> findAll(){
		return repo.findAll();
	}
	
	public Page<Neighborhood> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	/*
	public Neighborhood from(Neighborhood objDto) {
		return new Neighborhood(objDto.getId(), objDto.getName());
	}
	*/
	public void updataData(Neighborhood newObj, Neighborhood obj) {
		newObj.setName(obj.getName());
	}
}
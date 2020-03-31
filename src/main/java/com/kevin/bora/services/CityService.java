package com.kevin.bora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.City;
import com.kevin.bora.domain.State;
import com.kevin.bora.dto.CityDTO;
import com.kevin.bora.dto.CityNewDTO;
import com.kevin.bora.repositories.CityRepository;
import com.kevin.bora.services.exceptions.DataIntegrityException;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class CityService {

	@Autowired
	private CityRepository repo;
	@Autowired
	private StateService stateService;
	
	public List<City> findAll(){
		return repo.findAll();
	}
	
	public City find( Integer id ) {
		Optional<City> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + City.class.getName()));
	}

	public City insert(City city) {
		return repo.save(city);
	}
	
	public City update(CityDTO obj, Integer id) {
		City newObj = find(id);
		newObj.setName(obj.getName());
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
	public City fromNewDTO(CityNewDTO objNewDto) {
		State state = stateService.find(objNewDto.getState_id());
		return new City(null, objNewDto.getName(), state);
	}
}

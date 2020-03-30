package com.kevin.bora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.Address;
import com.kevin.bora.domain.City;
import com.kevin.bora.domain.Neighborhood;
import com.kevin.bora.domain.User;
import com.kevin.bora.domain.enums.Permission;
import com.kevin.bora.dto.UserDTO;
import com.kevin.bora.dto.UserNewDTO;
import com.kevin.bora.repositories.AddressRepository;
import com.kevin.bora.repositories.CityRepository;
import com.kevin.bora.repositories.NeighborhoodRepository;
import com.kevin.bora.repositories.UserRepository;
import com.kevin.bora.services.exceptions.DataIntegrityException;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private NeighborhoodRepository neighborhoodRepository;
	@Autowired
	private CityRepository cityRepository;
	
	
	public User find( Integer id ) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + User.class.getName()));
	}
	
	public User insert(User obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("It's impossible to delete a user now");
		}
	}
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public Page<User> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
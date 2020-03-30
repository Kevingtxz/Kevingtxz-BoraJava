package com.kevin.bora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.Address;
import com.kevin.bora.repositories.AddressRepository;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repo;
	
	public Address find( Integer id ) {
		Optional<Address> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + Address.class.getName()));
	}
	
	public List<Address> findAll(){
		return repo.findAll();
	}
	
	public Page<Address> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Address insert(Address obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Address update(Address obj) {
		Address newObj = find(obj.getId());
		updataData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void updataData(Address newObj, Address obj) {
		if(obj.getId() != null) {
			newObj.setId(obj.getId());
		}
		if(obj.getComplement() != null) {
			newObj.setComplement(obj.getComplement());
		}
		if(obj.getNeighborhood() != null) {
			newObj.setNeighborhood(obj.getNeighborhood());
		}
	}
}














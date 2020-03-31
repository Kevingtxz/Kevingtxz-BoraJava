package com.kevin.bora.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kevin.bora.domain.Message;
import com.kevin.bora.dto.MessageNewDTO;
import com.kevin.bora.services.MessageService;

@RestController
@RequestMapping(value="/message")
public class MessageResource {
	
	@Autowired
	private MessageService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Message> find(@PathVariable Integer id) {
		Message obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody MessageNewDTO objNewDto){
		Message obj = service.insert(objNewDto.getChat(), objNewDto.getSender_id(), objNewDto.getMsg());
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
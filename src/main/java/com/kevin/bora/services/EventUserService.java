package com.kevin.bora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.EventUser;
import com.kevin.bora.domain.EventUsers;
import com.kevin.bora.domain.Notification;
import com.kevin.bora.domain.enums.Participation;
import com.kevin.bora.domain.enums.Permission;
import com.kevin.bora.dto.EventUserDTO;
import com.kevin.bora.dto.EventUserNewDTO;
import com.kevin.bora.repositories.EventUserRepository;
import com.kevin.bora.repositories.EventUsersRepository;
import com.kevin.bora.repositories.NotificationRepository;
import com.kevin.bora.services.exceptions.DataIntegrityException;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class EventUserService {

	@Autowired
	private EventUserRepository repo;
	@Autowired
	private EventUsersRepository eventUsersRepository;
	@Autowired
	private NotificationRepository notificationRepository;
	@Autowired
	private EventUsersService eventUsersService;
	@Autowired
	private UserService userService;
	
	public EventUser find( Integer id ) {
		Optional<EventUser> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + EventUser.class.getName()));
	}
	
	public EventUser insert(EventUser obj, EventUserNewDTO objNewDto) {
		obj.setId(null);
		EventUsers eventUsers = eventUsersService.find(objNewDto.getEventUsersId());
		Notification notification = new Notification(null, "Novo seguidor", obj.getUser().getNickName() +" agora segue a sua página", false, eventUsers.getEvent());
		repo.save(obj);
		eventUsers.getEventUserList().add(obj);
		notificationRepository.save(notification);
		eventUsersRepository.save(eventUsers);
		return obj;
	}

	public EventUser update(EventUserDTO objDto, Integer id) {
		EventUser newObj = find(id);
		 updataData(newObj, objDto);
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
	
	public EventUser fromDTO(EventUserNewDTO objDto) {
		return new EventUser(null, Permission.toEnum(objDto.getPermissionId()), Participation.toEnum(objDto.getParticipationId()), userService.find(objDto.getUserId()));
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
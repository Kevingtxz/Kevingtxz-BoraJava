package com.kevin.bora.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.Category;
import com.kevin.bora.domain.Chat;
import com.kevin.bora.domain.City;
import com.kevin.bora.domain.Event;
import com.kevin.bora.domain.EventUser;
import com.kevin.bora.domain.EventUsers;
import com.kevin.bora.domain.Neighborhood;
import com.kevin.bora.domain.State;
import com.kevin.bora.domain.User;
import com.kevin.bora.domain.enums.Permission;
import com.kevin.bora.repositories.CategoryRepository;
import com.kevin.bora.repositories.ChatRepository;
import com.kevin.bora.repositories.CityRepository;
import com.kevin.bora.repositories.EventRepository;
import com.kevin.bora.repositories.EventUserRepository;
import com.kevin.bora.repositories.EventUsersRepository;
import com.kevin.bora.repositories.NeighborhoodRepository;
import com.kevin.bora.repositories.StateRepository;
import com.kevin.bora.repositories.UserRepository;

@Service
public class DBService {


	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EventUsersRepository eventUsersRepository;
	@Autowired
	private NeighborhoodRepository neighborhoodRepository;
	@Autowired
	private ChatRepository chatRepository;
	@Autowired
	private EventUserRepository eventUserRepository;
	
	public void instantiateTestDatabase() {
		
		
		State s1 = new State(null, "RJ");
		State s2 = new State(null, "SP");
		State s3 = new State(null, "RG");
		
		City c1 = new City(null, "Macaé", s1);
		City c2 = new City(null, "São Paulo", s2);
		City c3 = new City(null, "Rio Grande", s3);

		Neighborhood n1 = new Neighborhood(null, "Mirante da Lagoa", c1);
		Neighborhood n2 = new Neighborhood(null, "Cassino", c1);
		Neighborhood n3 = new Neighborhood(null, "Lagomar", c3);
	
		n1.setCity(c1);
		n3.setCity(c1);
		n2.setCity(c3);
		
		User u1 = new User(null,  "Kevin", "Gonçalves", "21/10", "kevingtxz@gmail.com", Permission.OWNER, "M", "aa", "adadd66a", "ffsfs", n1);
		User u2 = new User(null, "Bug", "Mello", "10/2", "melo@hotmail.com", null, "F", "adfa", "ad54adda", "ffsfs",n1);
		User u3 = new User(null,"Walter", "Vargas", "25/03", "waltinho@wal.com", Permission.MANAGER, "M", "adf", "adda", "ffsfs", n1);
		User u4 = new User(null, "Fernando", "Rogzar", "31/10", "feZ@yahoo.com", Permission.OWNER, "M", "affa", "adad", "ffsfs", n3);
		User u5 = new User(null, "Rona", "Megalo", "30/2", "rox@hotmail.com", null, "F", "adffa", "ad55adda", "ffsfs", n2);
		User u6 = new User(null, "Matheus", "Cordeiro", "29/03", "cord@cod.com", Permission.USER, "F", "dffa", "ada", "ffsfs", n2);

		
		
		
		Category cat1 = new Category(null, "Esporte");
		Category cat2 = new Category(null, "Festa");	
		Category cat3 = new Category(null, "Rolê");
		Category cat4 = new Category(null, "Voluntário");	
		Category cat5 = new Category(null, "Dança");
		Category cat6 = new Category(null, "Atividade em grupo");

		Chat chat7 = new Chat(null);
		Chat chat8 = new Chat(null);
		Chat chat9 = new Chat(null);
		Chat chat10 = new Chat(null);
		Chat chat11 = new Chat(null);
		Chat chat12 = new Chat(null);

		
		Event e1 = new Event(null, "Futebol", "24/03/2020", cat1, n3, "fskifsfs", "fssffs");
		Event e2 = new Event(null, "Vôlei", "21/10/2020", cat1, n2, "fskifadfsfs", "fssffs");
		Event e3 = new Event(null, "Boate", "01/01/2020",cat2, n3, "fskifsfs@aafaf", "fssffs");
		Event e4 = new Event(null, "Axe", "20/01/2020", cat2, n2,  "fskifs@fs", "fssffs");
		Event e5 = new Event(null, "Basquete", "10/03/20", cat1, n1,  "fs@kifsfs", "fssffs");
		Event e6 = new Event(null, "Caminhada", "10/03/20", cat6, n1,  "@fskifsfs", "fssffs");


		Chat chat1 = new Chat(null);
		Chat chat2 = new Chat(null);
		Chat chat3 = new Chat(null);
		Chat chat4 = new Chat(null);
		Chat chat5 = new Chat(null);

		
		
		EventUsers eu1 = new EventUsers(null, e1, chat7);
		EventUsers eu2 = new EventUsers(null, e2, chat8);
		EventUsers eu3 = new EventUsers(null, e3, chat9);

		EventUser eU1 = new EventUser(null, u2, eu1);
		EventUser eU2 = new EventUser(null, u3, eu2);
		EventUser eU3 = new EventUser(null, u1, eu3);
		
		
		cat1.getEvents().addAll(Arrays.asList(e1,e2));
		cat2.getEvents().addAll(Arrays.asList(e3, e4));
		cat3.getEvents().addAll(Arrays.asList(e1,e2, e3));
		
		s1.getCities().addAll(Arrays.asList(c1));
		s2.getCities().addAll(Arrays.asList(c2));
		s3.getCities().addAll(Arrays.asList(c3));

		u1.getPhones().addAll(Arrays.asList("90909090"));
		u2.getPhones().addAll(Arrays.asList("50909090"));
		u2.getPhones().addAll(Arrays.asList("00909090"));

		eu1.getEventUserList().addAll(Arrays.asList(eU2, eU3));
		eu3.getEventUserList().addAll(Arrays.asList(eU1));

		chat1.getUsers().addAll(Arrays.asList(u1, u2, u3));
		
		stateRepository.saveAll(Arrays.asList(s1, s2, s3));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
		neighborhoodRepository.saveAll(Arrays.asList(n1, n2, n3));		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
		eventRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6));
		chatRepository.saveAll(Arrays.asList(chat1, chat2, chat3, chat4, chat5, chat7, chat8, chat9, chat10, chat11, chat12));
		eventUsersRepository.saveAll(Arrays.asList(eu1,eu2, eu3));
		eventUserRepository.saveAll(Arrays.asList(eU1, eU2, eU3));
	
	}
}

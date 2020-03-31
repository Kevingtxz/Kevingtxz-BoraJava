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
import com.kevin.bora.domain.LoginEvent;
import com.kevin.bora.domain.LoginUser;
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
import com.kevin.bora.repositories.LoginEventRepository;
import com.kevin.bora.repositories.LoginUserRepository;
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
	private LoginUserRepository LoginUserserRepository;
	@Autowired
	private LoginEventRepository LoginEventventRepository;
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
	
		LoginUser LoginUser1 = new LoginUser(null, "Kevingtxz", "sfnkkonfs");
		LoginUser LoginUser2 = new LoginUser(null, "adg", "sfnkkonfs");
		LoginUser LoginUser3 = new LoginUser(null, "gdagdadg", "sfnkkonfs");
		LoginUser LoginUser4 = new LoginUser(null, "gadadg", "sfnkkonfs");
		LoginUser LoginUser5 = new LoginUser(null, "agddggadadg", "sfnkkonfs");
		LoginUser LoginUser6 = new LoginUser(null, "afhafhafhafh", "sfnkkonfs");
		
		
		User u1 = new User(null,  "Kevin", "Gonçalves", "21/10", "kevingtxz@gmail.com", "M", Permission.OWNER, c3, LoginUser1);
		User u2 = new User(null, "Bug", "Mello", "10/2", "melo@hotmail.com", "F", null, c2, LoginUser2);
		User u3 = new User(null,"Walter", "Vargas", "25/03", "waltinho@wal.com", "M", Permission.MANAGER, c1, LoginUser3);
		User u4 = new User(null, "Fernando", "Rogzar", "31/10", "feZ@yahoo.com", "M", Permission.OWNER, c3, LoginUser4);
		User u5 = new User(null, "Rona", "Megalo", "30/2", "rox@hotmail.com", "F", null, c1, LoginUser5);
		User u6 = new User(null, "Matheus", "Cordeiro", "29/03", "cord@cod.com", "F", Permission.USER, c2, LoginUser6);

		
		
		Category cat1 = new Category(null, "Esporte");
		Category cat2 = new Category(null, "Festa");	
		Category cat3 = new Category(null, "Rolê");
		Category cat4 = new Category(null, "Voluntário");	
		Category cat5 = new Category(null, "Dança");
		Category cat6 = new Category(null, "Atividade em grupo");


		LoginEvent LoginEvent1 = new LoginEvent(null, "Voleizin", "fjsojfs");
		LoginEvent LoginEvent2 = new LoginEvent(null, "Fut", "fgw");
		LoginEvent LoginEvent3 = new LoginEvent(null, "bas", "w,");
		LoginEvent LoginEvent4 = new LoginEvent(null, "ad", "fs");
		LoginEvent LoginEvent5 = new LoginEvent(null, "qe", "sf");
		LoginEvent LoginEvent6 = new LoginEvent(null, "fs", "fs");
		
		Event e1 = new Event(null, "Futebol", "24/03/2020", cat1, c1, LoginEvent1, "fskifsfs");
		Event e2 = new Event(null, "Vôlei", "21/10/2020", cat1, c2, LoginEvent2, "fskifadfsfs");
		Event e3 = new Event(null, "Boate", "01/01/2020",cat2, c2, LoginEvent3, "fskifsfs@aafaf");
		Event e4 = new Event(null, "Axe", "20/01/2020", cat2, c1, LoginEvent4, "fskifs@fs");
		Event e5 = new Event(null, "Basquete", "10/03/20", cat1, c1, LoginEvent5, "fs@kifsfs");
		Event e6 = new Event(null, "Caminhada", "10/03/20", cat6, c2, LoginEvent6, "@fskifsfs");


		Chat chat1 = new Chat(null);
		Chat chat2 = new Chat(null);
		Chat chat3 = new Chat(null);
		Chat chat4 = new Chat(null);
		Chat chat5 = new Chat(null);
		Chat chat6 = new Chat(null);
		Chat chat7 = new Chat(null);
		Chat chat8 = new Chat(null);
		Chat chat9 = new Chat(null);
		Chat chat10 = new Chat(null);
		Chat chat11 = new Chat(null);
		Chat chat12 = new Chat(null);
		Chat chat13 = new Chat(null);
		Chat chat14 = new Chat(null);
		Chat chat15 = new Chat(null);
		Chat chat16 = new Chat(null);

		
		
		EventUsers eu1 = new EventUsers(null, LoginEvent1, chat11);
		EventUsers eu2 = new EventUsers(null, LoginEvent2, chat12);
		EventUsers eu3 = new EventUsers(null, LoginEvent3, chat13);
		EventUsers eu4 = new EventUsers(null, LoginEvent4, chat14);
		EventUsers eu5 = new EventUsers(null, LoginEvent5, chat15);
		EventUsers eu6 = new EventUsers(null, LoginEvent6, chat16);

		EventUser eU1 = new EventUser(null, LoginUser1, eu6);
		EventUser eU2 = new EventUser(null, LoginUser2, eu2);
		EventUser eU3 = new EventUser(null, LoginUser3, eu3);
		EventUser eU4 = new EventUser(null, LoginUser4, eu4);
		EventUser eU5 = new EventUser(null, LoginUser5, eu5);
		EventUser eU6 = new EventUser(null, LoginUser6, eu1);
		
		
		cat1.getEvents().addAll(Arrays.asList(e1,e2));
		cat2.getEvents().addAll(Arrays.asList(e3, e4));
		cat3.getEvents().addAll(Arrays.asList(e1,e2, e3));
		cat4.getEvents().addAll(Arrays.asList(e3));
		cat5.getEvents().addAll(Arrays.asList(e1));
		cat6.getEvents().addAll(Arrays.asList(e3, e4, e1, e2));
		
		s1.getCities().addAll(Arrays.asList(c1));
		s2.getCities().addAll(Arrays.asList(c2));
		s3.getCities().addAll(Arrays.asList(c3));

		u1.getPhones().addAll(Arrays.asList("90909090"));
		u6.getPhones().addAll(Arrays.asList("50909090"));
		u2.getPhones().addAll(Arrays.asList("00909090"));

		eu1.getEventUserList().addAll(Arrays.asList(eU2, eU3, eU4));
		eu3.getEventUserList().addAll(Arrays.asList(eU1, eU5));
		eu4.getEventUserList().addAll(Arrays.asList(eU3));
		eu5.getEventUserList().addAll(Arrays.asList(eU4, eU3));
		eu6.getEventUserList().addAll(Arrays.asList(eU6));

		chat1.getLogins().addAll(Arrays.asList(LoginUser1, LoginUser2, LoginUser3));
		
		stateRepository.saveAll(Arrays.asList(s1, s2, s3));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
		neighborhoodRepository.saveAll(Arrays.asList(n1, n2, n3));		
		LoginUserserRepository.saveAll(Arrays.asList(LoginUser1, LoginUser2, LoginUser3, LoginUser4, LoginUser5, LoginUser6));
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
		LoginEventventRepository.saveAll(Arrays.asList(LoginEvent1, LoginEvent2, LoginEvent3, LoginEvent4, LoginEvent5, LoginEvent6));
		eventRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6));
		chatRepository.saveAll(Arrays.asList(chat1, chat2, chat3, chat4, chat5, chat6, chat7, chat8, chat9, chat10, chat11, chat12, chat13, chat14, chat15, chat16));
		eventUsersRepository.saveAll(Arrays.asList(eu1,eu2, eu3, eu4, eu5, eu6));
		eventUserRepository.saveAll(Arrays.asList(eU1, eU2, eU3, eU4, eU5, eU6));
	
	}
}

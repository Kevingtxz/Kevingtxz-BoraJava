package com.kevin.bora.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.Address;
import com.kevin.bora.domain.Category;
import com.kevin.bora.domain.Chat;
import com.kevin.bora.domain.City;
import com.kevin.bora.domain.Event;
import com.kevin.bora.domain.EventUser;
import com.kevin.bora.domain.EventUsers;
import com.kevin.bora.domain.MPEvent;
import com.kevin.bora.domain.MPUser;
import com.kevin.bora.domain.Neighborhood;
import com.kevin.bora.domain.State;
import com.kevin.bora.domain.User;
import com.kevin.bora.domain.enums.Permission;
import com.kevin.bora.repositories.AddressRepository;
import com.kevin.bora.repositories.CategoryRepository;
import com.kevin.bora.repositories.ChatRepository;
import com.kevin.bora.repositories.CityRepository;
import com.kevin.bora.repositories.EventRepository;
import com.kevin.bora.repositories.EventUserRepository;
import com.kevin.bora.repositories.EventUsersRepository;
import com.kevin.bora.repositories.MPEventRepository;
import com.kevin.bora.repositories.MPUserRepository;
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
	private AddressRepository addressRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EventUsersRepository eventUsersRepository;
	@Autowired
	private NeighborhoodRepository neighborhoodRepository;
	@Autowired
	private ChatRepository chatRepository;
	@Autowired
	private MPUserRepository mPUserRepository;
	@Autowired
	private MPEventRepository mPEventRepository;
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
		
		Address a1 = new Address(null, "1024", "Casa Branca", n1);
		Address a2 = new Address(null, "108", "Preto", n3);
		Address a3 = new Address(null, "24", "Cinza", n2);

	
		MPUser mPU1 = new MPUser(null, "Kevingtxz", "sfnkkonfs");
		MPUser mPU2 = new MPUser(null, "adg", "sfnkkonfs");
		MPUser mPU3 = new MPUser(null, "gdagdadg", "sfnkkonfs");
		MPUser mPU4 = new MPUser(null, "gadadg", "sfnkkonfs");
		MPUser mPU5 = new MPUser(null, "agddggadadg", "sfnkkonfs");
		MPUser mPU6 = new MPUser(null, "afhafhafhafh", "sfnkkonfs");
		
		
		User u1 = new User(null,  "Kevin", "Gonçalves", "21/10", "kevingtxz@gmail.com", "M", Permission.OWNER, a3, mPU1);
		User u2 = new User(null, "Bug", "Mello", "10/2", "melo@hotmail.com", "F", null, a2, mPU2);
		User u3 = new User(null,"Walter", "Vargas", "25/03", "waltinho@wal.com", "M", Permission.MANAGER, a1, mPU3);
		User u4 = new User(null, "Fernando", "Rogzar", "31/10", "feZ@yahoo.com", "M", Permission.OWNER, a3, mPU4);
		User u5 = new User(null, "Rona", "Megalo", "30/2", "rox@hotmail.com", "F", null, a1, mPU5);
		User u6 = new User(null, "Matheus", "Cordeiro", "29/03", "cord@cod.com", "F", Permission.USER, a2, mPU6);

		
		
		Category cat1 = new Category(null, "Esporte");
		Category cat2 = new Category(null, "Festa");	
		Category cat3 = new Category(null, "Rolê");
		Category cat4 = new Category(null, "Voluntário");	
		Category cat5 = new Category(null, "Dança");
		Category cat6 = new Category(null, "Atividade em grupo");


		MPEvent mPE1 = new MPEvent(null, "Voleizin", "fjsojfs");
		MPEvent mPE2 = new MPEvent(null, "Fut", "fgw");
		MPEvent mPE3 = new MPEvent(null, "bas", "w,");
		MPEvent mPE4 = new MPEvent(null, "ad", "fs");
		MPEvent mPE5 = new MPEvent(null, "qe", "sf");
		MPEvent mPE6 = new MPEvent(null, "fs", "fs");
		
		Event e1 = new Event(null, "Futebol", "24/03/2020", cat1, a1, mPE1);
		Event e2 = new Event(null, "Vôlei", "21/10/2020", cat1, a2, mPE2);
		Event e3 = new Event(null, "Boate", "01/01/2020",cat2, a2, mPE3);
		Event e4 = new Event(null, "Axe", "20/01/2020", cat2, a1, mPE4);
		Event e5 = new Event(null, "Basquete", "10/03/20", cat1, a1, mPE5);
		Event e6 = new Event(null, "Caminhada", "10/03/20", cat6, a2, mPE6);


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

		
		
		EventUsers eu1 = new EventUsers(null, mPE1, chat11);
		EventUsers eu2 = new EventUsers(null, mPE2, chat12);
		EventUsers eu3 = new EventUsers(null, mPE3, chat13);
		EventUsers eu4 = new EventUsers(null, mPE4, chat14);
		EventUsers eu5 = new EventUsers(null, mPE5, chat15);
		EventUsers eu6 = new EventUsers(null, mPE6, chat16);

		EventUser eU1 = new EventUser(null, mPU1, eu6);
		EventUser eU2 = new EventUser(null, mPU2, eu2);
		EventUser eU3 = new EventUser(null, mPU3, eu3);
		EventUser eU4 = new EventUser(null, mPU4, eu4);
		EventUser eU5 = new EventUser(null, mPU5, eu5);
		EventUser eU6 = new EventUser(null, mPU6, eu1);
		
		
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

		stateRepository.saveAll(Arrays.asList(s1, s2, s3));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
		neighborhoodRepository.saveAll(Arrays.asList(n1, n2, n3));
		addressRepository.saveAll(Arrays.asList(a1, a2, a3));
		
	
		mPUserRepository.saveAll(Arrays.asList(mPU1, mPU2, mPU3, mPU4, mPU5, mPU6));
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
		mPEventRepository.saveAll(Arrays.asList(mPE1, mPE2, mPE3, mPE4, mPE5, mPE6));
		eventRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6));
		
		chatRepository.saveAll(Arrays.asList(chat1, chat2, chat3, chat4, chat5, chat6, chat7, chat8, chat9, chat10, chat11, chat12, chat13, chat14, chat15, chat16));
		eventUsersRepository.saveAll(Arrays.asList(eu1,eu2, eu3, eu4, eu5, eu6));
		
		eventUserRepository.saveAll(Arrays.asList(eU1, eU2, eU3, eU4, eU5, eU6));
	
	}
}

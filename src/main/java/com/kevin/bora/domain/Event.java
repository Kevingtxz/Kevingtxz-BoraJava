package com.kevin.bora.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String date;

	@Column(unique=true)
	private String nickName;
	@Column(unique=true)
	private String email;
	@JsonIgnore
	private String password;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "neighborhood_id")
	private Neighborhood neighborhood;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="eventUsers_id")
	private EventUsers eventUsers;

	public Event() {
	}

	public Event(Integer id, String nickName, String date, Category category, Neighborhood neighborhood, String email, String password) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.date = date;
		this.category = category;
		this.city = neighborhood.getCity();
		this.email = email;
		this.neighborhood = neighborhood;
		this.password = password; 
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Neighborhood getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(Neighborhood neighborhood) {
		this.neighborhood = neighborhood;
	}

	public EventUsers getEventUsers() {
		return eventUsers;
	}

	public void setEventUsers(EventUsers eventUsers) {
		this.eventUsers = eventUsers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
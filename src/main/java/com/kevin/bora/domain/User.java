package com.kevin.bora.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kevin.bora.domain.enums.Permission;

@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String lastName;
	private String birth;
	private String gender;	
	private Integer permission;
	private String notes; 
	
	@Column(unique=true)
	private String nickName;
	
	@Column(unique=true)
	private String email;
	@JsonIgnore
	private String password;
	
	@JsonIgnore
	@ElementCollection
	@CollectionTable(name="Phones")
	private Set<String> phones = new HashSet<>();

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "neighborhood_id")
	private Neighborhood neighborhood;

	public User() {
	}

	public User(Integer id, String name, String lastName, String birth, String gender, Permission permission, String notes,
			String nickName, String email, String password, Neighborhood neighborhood) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birth = birth;
		this.gender = gender;
		this.permission = (permission == null) ? null : permission.getCod();
		this.notes = notes;
		this.nickName = nickName;
		this.email = email;
		this.password = password;
		this.city = neighborhood.getCity();
		this.neighborhood = neighborhood;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Neighborhood getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(Neighborhood neighborhood) {
		this.neighborhood = neighborhood;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getPermission() {
		return permission;
	}

	public void setPermission(Integer permission) {
		this.permission = permission;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public City getAddress() {
		return city;
	}

	public void setAddress(City city) {
		this.city = city;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
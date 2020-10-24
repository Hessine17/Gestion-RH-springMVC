package com.essths.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int id_user;
	private String user_name;
	private String password;
	@OneToMany
	@JoinColumn(name="id_user")
	private Collection<Role> roles;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	public User(int id_user, String user_name, String password) {
		super();
		this.id_user = id_user;
		this.user_name = user_name;
		this.password = password;
	}
	

}

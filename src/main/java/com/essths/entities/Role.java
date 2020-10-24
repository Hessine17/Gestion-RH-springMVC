package com.essths.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Role {
	@Id
	@GeneratedValue
private int idRole;
private  String nameRole;
@ManyToOne
@JoinColumn(name="id_user")
private User user;
public int getIdRole() {
	return idRole;
}
public void setIdRole(int idRole) {
	this.idRole = idRole;
}
public String getNameRole() {
	return nameRole;
}
public void setNameRole(String nameRole) {
	this.nameRole = nameRole;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Role(int idRole, String nameRole) {
	super();
	this.idRole = idRole;
	this.nameRole = nameRole;
}
public Role() {
	super();
	// TODO Auto-generated constructor stub
}

}

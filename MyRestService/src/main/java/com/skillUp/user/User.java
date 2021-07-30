package com.skillUp.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name="USERS")
public class User {
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="ID")
@Id
private int id;
@Column(name="NAME")
private String name;
@Column(name="DOB")
private Date dateOfBirth;

public User() {
	super();
}

public User(int id, String name, Date dateOfBirth) {
	super();
	this.id = id;
	this.name = name;
	this.dateOfBirth = dateOfBirth;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}

}

package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="xt_user_profile_roles")
public class Role {

	@Id
	@GeneratedValue
	@Column(name = "ROLE_ID")
	private int id;
	private String name;
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role( String name) {
		//super();
		//this.id = id;
		this.name = name;
	}
	
	Role(){}
	
}

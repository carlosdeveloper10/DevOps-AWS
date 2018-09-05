package com.amazonaws.lambda.clients;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {

	@Id
	private Integer clientID;
	private String name;
	
	public Integer getClientID() {
		return clientID;
	}
	public void setClientID(Integer clientID) {
		this.clientID = clientID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

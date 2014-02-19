package com.example.banknote.model;

public class UserCredential {
	private long id;
	private String credentials;
	
	public void setId(long id){
		this.id = id;
	}
	
	public void setCredentials(String credentials){
		this.credentials = credentials;
	}
	
	public long getId(){
		return id;
	}
	
	public String getCredentials(){
		return credentials;
	}
	
	@Override
	public String toString(){
		return credentials;
	}
}

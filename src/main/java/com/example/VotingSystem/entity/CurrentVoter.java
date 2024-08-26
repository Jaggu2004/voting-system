package com.example.VotingSystem.entity;

public class CurrentVoter {
	
	private int id;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "CurrentVoter [id=" + id + ", password=" + password + "]";
	}
	public CurrentVoter(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public CurrentVoter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

package com.example.VotingSystem.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Voter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	@NotBlank(message = "Name Cannot be empty")
	@Size(min=4,max=8,message = "Name should have 4 to 8 Characters")
	@Pattern(regexp = "^[a-zA-Z]+$",message = "only characters allowed" )
	private String name;
	private Date  DOB;
	private String gender;
	private String username;
	private String password;
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
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Voter [id=" + id + ", name=" + name + ", DOB=" + DOB + ", gender=" + gender + ", username=" + username
				+ ", password=" + password + "]";
	}
	public Voter(int id,
			@NotBlank(message = "Name Cannot be empty") @Size(min = 4, max = 8, message = "Name should have 4 to 8 Characters") @Pattern(regexp = "^[a-zA-Z]+$", message = "only characters allowed") String name,
			Date dOB, String gender, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		DOB = dOB;
		this.gender = gender;
		this.username = username;
		this.password = password;
	}
	public Voter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}

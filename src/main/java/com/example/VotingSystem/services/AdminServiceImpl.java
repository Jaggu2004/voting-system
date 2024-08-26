package com.example.VotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.VotingSystem.entity.Admin;
import com.example.VotingSystem.repository.Repo;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	Repo repo;
	@Override
	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		repo.save(admin);
		
	}

	@Override
	public List<Admin> adminList() {
		// TODO Auto-generated method stub
		List<Admin> find = repo.findAll();
		return find;
	}

	@Override
	public Admin getAdmin(int id) {
		// TODO Auto-generated method stub
		Admin admin = repo.getById(id);
	  
		return admin;
	}

}

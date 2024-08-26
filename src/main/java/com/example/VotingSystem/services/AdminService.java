package com.example.VotingSystem.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.VotingSystem.entity.Admin;

@Service
public interface AdminService {

	public void saveAdmin(Admin admin);
	public List<Admin> adminList();
	public Admin getAdmin(int id);
}

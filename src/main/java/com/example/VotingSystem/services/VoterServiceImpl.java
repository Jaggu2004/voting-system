package com.example.VotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.VotingSystem.entity.Admin;
import com.example.VotingSystem.entity.Voter;
import com.example.VotingSystem.repository.VoterRepo;

@Service
public class VoterServiceImpl implements VoterService{

	@Autowired
	VoterRepo voterRepo;
	@Override
	public Voter saveVoter(Voter voter) {
		// TODO Auto-generated method stub
		voterRepo.save(voter);
		return voter;
	}

	@Override
	public List<Voter> voterList() {
		List<Voter> find = voterRepo.findAll();
		return find;
	}

	@Override
	public void deleteById(int id) {
		voterRepo.deleteById(id);
	}

	@Override
	public Voter findbyId(int id) {
		Voter voter = voterRepo.getById(id);
		return voter;
	}

	@Override
	public Voter updateVoter(Voter voter) {
		// TODO Auto-generated method stub
		voterRepo.save(voter);
		return voter;
	}

}

package com.example.VotingSystem.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.VotingSystem.entity.Voter;

@Service
public interface VoterService {

	public Voter saveVoter(Voter voter);
	public List<Voter> voterList();
	public void deleteById(int id);
	public Voter findbyId(int id);
	public Voter updateVoter(Voter voter);
}

package com.example.VotingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.VotingSystem.entity.Voter;

@Repository
public interface VoterRepo extends JpaRepository<Voter, Integer>{

}

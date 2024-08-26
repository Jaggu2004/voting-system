package com.example.VotingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.VotingSystem.entity.Admin;

@Repository
public interface Repo extends JpaRepository<Admin, Integer> {

}

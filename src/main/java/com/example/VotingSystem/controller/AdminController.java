package com.example.VotingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.VotingSystem.entity.Admin;
import com.example.VotingSystem.repository.Repo;
import com.example.VotingSystem.services.AdminService;

import jakarta.validation.Valid;

@Controller
public class AdminController {
	
	   @Autowired
	   Repo adminRepository;
	   
	   @Autowired
	   AdminService adminService;
	   
	   @GetMapping("/")
	    public String index(Model model) {
	        model.addAttribute("admin", new Admin());
	        return "index";
	    }
	
	   @GetMapping("/registerAdmin")
       public String saveAdmin(Model model)
       {
		  model.addAttribute("admin",new Admin());
    	  return "adminregister";   
       }
	   
	  
	   @PostMapping("/saveUser")
	    public String saveUser(@ModelAttribute("admin") Admin admin) {
		    System.out.println(admin.toString());
	        adminService.saveAdmin(admin);
	        return "adminlogin"; // Redirect to a success page or form
	    }
	   
	    @GetMapping("/loginAdmin")
	    public String showLoginForm(Model model) {
	        model.addAttribute("admin", new Admin());
	        return "adminlogin";
	    }
	    
	    @GetMapping("/adminDash")
	    public String adminDashboard(Model model) {
	        model.addAttribute("loginForm", new Admin());
	        return "adminDash";
	    }
	   
	   @PostMapping("/loginsts")
	    public String loginUser(@ModelAttribute("admin") Admin admin) {
		    System.out.println(admin.toString());
		     int id = admin.getId();
		     String password = admin.getPassword();
		     Admin oldAdmin = adminService.getAdmin(id);
		     String oldPassword = oldAdmin.getPassword();
		     if(oldPassword.equals(password)) {
		    	 System.out.println("Loged In");
		    	 return "adminDash";
		     }
		     else {
		    	 return "error";
		     }
	        
	    }
	   
	   
	   
	   
	   
}
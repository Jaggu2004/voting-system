package com.example.VotingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.VotingSystem.entity.Admin;
import com.example.VotingSystem.entity.CurrentVoter;
import com.example.VotingSystem.entity.Voter;
import com.example.VotingSystem.repository.VoterRepo;
import com.example.VotingSystem.services.VoterService;

@Controller
public class VoterController {

	@Autowired
	VoterRepo voterRepo;
	
	@Autowired
	VoterService voterService;
	
	
	 @GetMapping("/loginVoter")
	    public String showLoginForm(Model model) {
	        model.addAttribute("voter", new Voter());
	        return "voterlogin";
	    }
	 
	    @PostMapping("/afterloginvoter")
	    public String loginUser(@ModelAttribute("voter") Voter voter) {
		     int id = voter.getId();
		     String password = voter.getPassword();
		     Voter oldvoter = voterService.findbyId(id);
		     String oldPassword = oldvoter.getPassword();
		     if(oldPassword.equals(password)) {
		    	 CurrentVoter cv = new CurrentVoter();
		    	 cv.setId(id);
		    	 cv.setPassword(oldPassword);
		    	 System.out.println("Loged In");
		    	 return "voterDash";
		     }
		     else {
		    	 return "error";
		     }
	        
	    }
	 

	   @GetMapping("/registerVoter")
     public String saveVoter2(Model model)
     {
		  model.addAttribute("voter",new Admin());
  	  return "voterregister";   
     }
	   
	@GetMapping("/addvoter")
    public String saveVoter(Model model)
    {
		  model.addAttribute("voter",new Voter());
 	      return "addvoter";   
    }
	
	 @PostMapping("/afteraddvoter")
	    public String save3Voter(@ModelAttribute("voter") Voter voter) {
		    System.out.println(voter.toString());
	        voterService.saveVoter(voter);
	        return "voterlogin"; // Redirect to a success page or form
	    }
	 
	 @GetMapping("/voterDash")
	    public String voterDashboard(Model model) {
	        model.addAttribute("voter", new Voter());
	        return "voterDash";
	    }
	
	 @PostMapping("/saveVoter")
	    public String saveVoter(@ModelAttribute("voter") Voter voter) {
		    System.out.println(voter.toString());
	        voterService.saveVoter(voter);
	        return "adminDash"; // Redirect to a success page or form
	    }
	 
	 
	 
	 @GetMapping("/viewallvoters")
	 public String viewallvoters(Model model)
	 {
		 List<Voter> voters  =voterService.voterList();
		 model.addAttribute("voters" , voters);
		 for(Voter v : voters) {
			 System.out.println(v);
		 }
		return "viewallvoters";
	 }
	 @GetMapping("/viewallvotersbyupdate")
	 public String viewallvotersbyupdate(Model model)
	 {
		 List<Voter> voters  =voterService.voterList();
		 model.addAttribute("voters" , voters);
		 for(Voter v : voters) {
			 System.out.println(v);
		 }
		return "viewallvoters";
	 }
	 @GetMapping("/viewallvotersbydelete")
	 public String viewallvotersbydelete(Model model)
	 {
		 List<Voter> voters  =voterService.voterList();
		 model.addAttribute("voters" , voters);
		 for(Voter v : voters) {
			 System.out.println(v);
		 }
		return "viewallvoters";
	 }
	 
	 
	 
	 @GetMapping("/viewonevoter")
	    public String viewonevoter(Model model) {
	    	model.addAttribute("voter",new Voter());
			return "viewonevoter";
	    	
	    }
	 
	 @PostMapping("/search")
	    public String searchVoter(@RequestParam("voterId") Integer voterId, Model model) {
	        Voter voter = voterService.findbyId(voterId);
	        model.addAttribute("voter", voter);
	        return "viewonevoter"; // Thymeleaf template name
	    }

	 
	 
	    @GetMapping("/delete/{id}")
	    public String deleteVoter(@PathVariable("id") Integer id) {
	        voterService.deleteById(id);
	        return "redirect:/viewallvoters"; // Redirect to the list of voters after deletion
	    }
	    
	    
	    Integer id = null;
	    
	    
	    @GetMapping("/updatevoter/{id}")
	    public String updatevoter(@PathVariable("id") Integer id,Model model) {
	    	this.id = id;
	    	model.addAttribute("voter",new Voter());
			return "updatevoter";
	    	
	    }

	    
	    @PostMapping("/update")
	    public String showUpdateForm(@ModelAttribute Voter voter) {
	        Voter v = voterService.findbyId(id);
	        v.setName(voter.getName());
	        v.setDOB(voter.getDOB());
	        v.setGender(voter.getGender());
	        v.setUsername(voter.getUsername());
	        v.setPassword(voter.getPassword());
	        voterService.updateVoter(v);
	        return "adminDash";
	    }
	  
}

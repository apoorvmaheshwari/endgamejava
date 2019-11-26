package com.classifieds.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.classifieds.admin.model.Ads;
import com.classifieds.admin.model.User;

import com.classifieds.admin.repo.AdsDal;
import com.classifieds.admin.repo.UserDal;
@RestController
public class AdminController {
	@Autowired
	private UserDal userDal;
	
	@Autowired 
	private AdsDal adsDal;
	
	@DeleteMapping(path = {"/admin/{email}"})
	public void deleteUser(@PathVariable("email") String email){
		
		userDal.deleteUser(email);
			
		 
	}
	@DeleteMapping("/admin/{id}/{username}")
	public void delAds(@PathVariable String id,@PathVariable String username) {
		
		userDal.findAd(id, username);
		
	}
	
	@GetMapping("/admin")
	public List<Ads> findAllads() {
		System.out.println("Inss");
		return adsDal.findAll();
	}
	
	@RequestMapping(value = "/udmin/users", method = RequestMethod.GET, produces = "application/json")
	public List<User> findAllusers() {
		return userDal.findAll();
	}
	

}

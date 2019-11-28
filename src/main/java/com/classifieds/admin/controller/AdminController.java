package com.classifieds.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.classifieds.admin.model.Admin;
import com.classifieds.admin.model.Ads;
import com.classifieds.admin.model.User;
import com.classifieds.admin.repo.AdminDal;
import com.classifieds.admin.repo.AdsDal;
import com.classifieds.admin.repo.UserDal;
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class AdminController {
	@Autowired
	private UserDal userDal;
	
	@Autowired 
	private AdsDal adsDal;
	
	@Autowired
	private AdminDal adminDal;
	
	@PostMapping("/admin")
	public Admin create(@RequestBody Admin user){
		adminDal.create(user);
		
		System.out.println(user + " insert");
		return user;
	}
	
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
	@GetMapping("/admin/{email}/{password}")
	public String adminPass(@PathVariable String email, @PathVariable String password) {
		System.out.println(email);
		System.out.println(password);
		return adminDal.findByemailPass(email, password);
		
		
	}
	@DeleteMapping("/admin/{email}/{title}")
	public void remv(@PathVariable String email,@PathVariable String title){
		userDal.delete(email, title);
	}
	@DeleteMapping("/admin/{title}")
	public void deletead(@PathVariable String postTitle) {
		adsDal.deleteAdtitle(postTitle);
	}

	

}

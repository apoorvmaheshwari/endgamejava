package com.classifieds.admin.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.classifieds.admin.model.Ads;
import com.classifieds.admin.model.User;
import com.classifieds.admin.model.Userad;
import com.classifieds.admin.repo.UserDal;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class UserController {
	
	@Autowired
	private UserDal userDal;
	
	@PostMapping("/users")
	public User create(@RequestBody User user){
		userDal.create(user);
		
		System.out.println(user + " insert");
		return user;
	}
	
	@DeleteMapping(path = {"/users/{email}"})
	public void delete(@PathVariable("email") String email){
		
		userDal.deleteUser(email);
		
		 
	}
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	public List<User> firstPage() {
		return userDal.findAll();
	}
	
	@GetMapping("/user/ads")
	public List<Ads> findAllAds(){
		return userDal.findAllAds();
	}
	
	@GetMapping("/user")
	public List<User> findAllUser(){
		return userDal.findAll();
	}
	@GetMapping("/users/{email}")
	public 	User findByemail(@PathVariable String email) {
		return userDal.findByemail(email);
	}
	@GetMapping("/users/{email}/{password}")
	public String userPass(@PathVariable String email, @PathVariable String password) {
		System.out.println(email);
		System.out.println(password);
		return userDal.findByemailPass(email, password);
		
		
	}
	@PutMapping("/users/{email}")
	public void updateAd(@PathVariable String email, @RequestBody Ads ad) {
		System.err.println("pu -> /users");
		System.err.println(ad);
		System.err.println("inside updatead");
		userDal.findbyadid(email, ad);
	}

}
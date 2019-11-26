package com.classifieds.admin.repo;

import java.util.List;

import com.classifieds.admin.model.Ads;
import com.classifieds.admin.model.User;

public interface UserDal {

	User create(User user);
	
	Boolean deleteUser(String email);
	
	List<User> findAll();
	
	User findByemail(String email);
	
	List<Ads> findAllAds();

	

	 void findAd(String id, String username);
}


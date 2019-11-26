package com.classifieds.admin.repo;

import java.util.List;

import com.classifieds.admin.model.Admin;
import com.classifieds.admin.model.Ads;
import com.classifieds.admin.model.User;


public interface AdminDal {
	
	Admin create(Admin admin);
	
	Boolean deleteAdmin(String userName);
	
	List<Admin> findAll();
	
	Admin findByuserName(String userName);
	
	List<User> findAllUser();
	
	List<Ads> findAllAds();
	
}

package com.classifieds.admin.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.classifieds.admin.model.Admin;
import com.classifieds.admin.model.Ads;
import com.classifieds.admin.model.User;

@Repository
public class AdminDalImpl implements AdminDal {

	@Autowired
	private MongoTemplate mongo;

	@Override
	public Admin create(Admin admin) {

		return mongo.save(admin);

	}

	@Override
	public Boolean deleteAdmin(String userName) {

		return mongo.remove(new Query(Criteria.where("userName").is(userName)), Admin.class).wasAcknowledged();
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return mongo.findAll(Admin.class);
	}

	@Override
	public Admin findByuserName(String username) {

		return mongo.findAndRemove(new Query(Criteria.where("userName").is(username)), Admin.class);
	}

	@Override
	public List<Ads> findAllAds() {
		// TODO Auto-generated method stub
		return mongo.findAll(Ads.class);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return mongo.findAll(User.class);
	}

	@Override
	public String findByemailPass(String email, String password) {

		Admin u = mongo.findOne(new Query(Criteria.where("userName").is(email)), Admin.class);
		System.err.println(u);
		if (u.getPassword().equals(password.trim())) {
			System.err.println(u.getPassword());
			System.err.println(password);
			return "true";
		} else {
			return "false";
		}
	}
}

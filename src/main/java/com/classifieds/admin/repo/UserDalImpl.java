package com.classifieds.admin.repo;

import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.classifieds.admin.model.*;

@Repository
public class UserDalImpl implements UserDal {

	@Autowired
	private MongoTemplate mongo;

	@Autowired
	private AdsDal adsDal;

	@Override
	public User create(User user) {

		return mongo.save(user);
	}

	@Override
	public Boolean deleteUser(String email) {

		return mongo.remove(new Query(Criteria.where("email").is(email)), User.class).wasAcknowledged();
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return mongo.findAll(User.class);
	}

	@Override
	public User findByemail(String email) {

		return mongo.findAndRemove(new Query(Criteria.where("email").is(email)), User.class);
	}

	@Override
	public User findbyEmailuser(String email) {
		return mongo.findOne(new Query(Criteria.where("email").is(email)), User.class);
	}

	@Override
	public String findByemailPass(String email, String password) {

		User u = mongo.findOne(new Query(Criteria.where("email").is(email)), User.class);
		if (u.getPassword().equals(password.trim())) {
			System.out.println(u.getPassword());
			System.out.println(password);
			return "true";
		} else {
			return "false";
		}
	}

	@Override
	public void findbyadid(String email, Ads a) {
		System.out.println("inside find by ad id");
		List<Ads> ad;
		User u = mongo.findOne(new Query(Criteria.where("email").is(email)), User.class);
		System.err.println("inside dal - > " + u);
		System.out.println(u.getEmail());
//		ad.add(ind, a);
		List<Ads> userAds = new ArrayList<Ads>();
		System.err.println(u.getAd().isEmpty());

		if (u.getAd() == null || u.getAd().isEmpty()) {
			System.err.println("yep it is null..");
			userAds.add(a);
			u.setAd(userAds);
		} else {
			userAds.add(a);
			u.getAd().addAll(userAds);
		}
		System.err.println("before save -> \n" + u);
		adsDal.create(a);
		mongo.save(u);
		// System.out.println(u.getAd());
		// mongo.updateFirst(new Query(Criteria.where("email").is(email)), new
		// Update().set("ad", ad), User.class);
	}

	@Override
	public int findbyuserId(String email, String a) {
		System.out.println("inside find by ad id");

		User u = mongo.findOne(new Query(Criteria.where("email").is(email)), User.class);
		System.err.println("inside dal - > " + u);
		System.out.println(u.getEmail());
		for (Ads ad : u.getAd()) {
			if (ad.getId() == a) {
				return 1;
			}
		}

		System.err.println("before save -> \n" + u);
		return 0;

		// System.out.println(u.getAd());
		// mongo.updateFirst(new Query(Criteria.where("email").is(email)), new
		// Update().set("ad", ad), User.class);
	}

	@Override
	public void findAd(String id, String username) {
		int ind = 0;
		User u = mongo.findOne(new Query(Criteria.where("user.ad.id").is(id)), User.class);
		List<Ads> li = u.getAd();
		for (Ads i : li) {
			if (i.getId().equals(id)) {
				ind = li.indexOf(i);
			}
		}
		li.remove(ind);
		mongo.updateFirst(new Query(Criteria.where("email").is(username)), new Update().set("ad", li), User.class);

	}

	@Override
	public List<Ads> findAllAds() {
		// TODO Auto-generated method stub
		return mongo.findAll(Ads.class);
	}

	@Override
	public void delete(String email, String id) {
		// TODO Auto-generated method stub
		int ind = 0;
		System.err.println(email);
		System.err.println(id);
		User u = mongo.findOne(new Query(Criteria.where("email").is(email)), User.class);
		List<Ads> al = u.getAd();
		for (Ads a : al) {
			if (a.getId().equals(id)) {
				ind = al.indexOf(a);
			}
		}
		al.remove(ind);
		u.setAd(al);
	}

	@Override
	public void getUserByAd(String id) {
		// TODO Auto-generated method stub
		User user = mongo.findOne(new Query(Criteria.where("ad").in(id)), User.class);
		System.err.println(user);
		UserDalImpl u = new UserDalImpl();
		u.deleteAd(user, id);
		
	}

	@Override
	public void deleteAd(User u, String id) {
		// TODO Auto-generated method stub
		int ind = 0;
		List<Ads> al = u.getAd();
		System.err.println("going in for");
		for (Ads a : al) {
			if (a.getId().equals(id)) {
				ind = al.indexOf(a);
			}
		}
		System.err.println("exiting for");
		al.remove(ind);
		u.setAd(al);
		//mongo.save(u);
		System.err.println("user saved");
	}
	
}
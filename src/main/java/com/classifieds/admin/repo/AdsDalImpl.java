package com.classifieds.admin.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.classifieds.admin.model.Ads;

@Repository
public class AdsDalImpl implements AdsDal {
	@Autowired
	private MongoTemplate mongo;
	
	@Override
	public Ads create(Ads ads) {
		
		return mongo.insert(ads);
		
	}
	@Override
	public void update(String id, Ads a) {
		// TODO Auto-generated method stub
		mongo.findAndModify(new Query(Criteria.where("id").is(id)), Update.update("as", a.getId()), Ads.class);
		
	}
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		mongo.findAndRemove(new Query(Criteria.where("id").is(id)), Ads.class);
	}
	@Override
	public List<Ads> findAll() {
		// TODO Auto-generated method stub
		return mongo.findAll(Ads.class);
	}
	
	@Override
	public List<Ads> findbyCategory(String category){
		Query q=new Query();
		q.addCriteria(Criteria.where("category").is(category));
		return mongo.find(q, Ads.class);
	}
	@Override
	public Ads find(String id) {
		Query q=new Query();
		q.addCriteria(Criteria.where("ad.id").is(id));
		return mongo.findOne(q, Ads.class);
	}

}

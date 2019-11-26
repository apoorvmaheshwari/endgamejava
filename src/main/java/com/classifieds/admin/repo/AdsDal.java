package com.classifieds.admin.repo;

import java.util.List;

import com.classifieds.admin.model.Ads;

public interface AdsDal {
	 com.classifieds.admin.model.Ads create(Ads ads);

		void update(String id, Ads a);

		void delete(String id);

		List<Ads> findAll();

		List<Ads> findbyCategory(String category);
		
		Ads find(String id);

}

package com.classifieds.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.classifieds.admin.model.Ads;
import com.classifieds.admin.repo.AdsDal;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class AdsController {
	@Autowired
	private AdsDal adal;

	@PostMapping("/adspost")
	public void create(@RequestBody Ads al) {
		System.out.println(" album controller -> " + al);
		adal.create(al);
	}

	@GetMapping("/ads/{category}")
	public List<Ads> find(@PathVariable String category) {
		return adal.findbyCategory(category);
	}
	@GetMapping("/ads/id/{id}")
	public Ads findby(@PathVariable String id) {
		return adal.viewbyid(id);
	}

	@GetMapping("/ads")
	public List<Ads> findAll() {
		return adal.findAll();
	}

	@DeleteMapping("/adss/{id}")
	public void del(@PathVariable String id) {
		adal.delete(id);
	}

	@DeleteMapping("/ads/{postTitle}")
	public void delad(@PathVariable String title) {
		adal.deleteAdtitle(title);
	}
}
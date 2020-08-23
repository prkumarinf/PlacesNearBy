package com.nearby.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nearby.model.Items;
import com.nearby.model.SearchModel;
import com.nearby.services.SearchNearBy;

@RestController
@RequestMapping("/searchNearBy")
public class SearchNearByController {
	
	@Autowired
	SearchNearBy searchNearBy;
	
	/*
	 * @PostMapping("/placesNearBy")
	 *  public String searchNearBy(@RequestBody
	 * SearchModel searchModel) 
	 *  *{ 
	 *  
	 *  searchNearBy.searchNearBy(searchModel.getAt(),
	 * searchModel.getCat()); return "Search Near By"; }
	 */
	
	/*
	 * @GetMapping("/placesNearBy/{at}/{cat}") public String
	 * 
	 * searchNearBy(@PathVariable("at") String at, @PathVariable("cat") String cat)
	 * 
	 * { searchNearBy.searchNearBy(at, cat); return "Search Near By"; }
	 */
	
	@GetMapping("/placesNearBy")
	  public List<Items> searchNearBy(@RequestParam String at, @RequestParam String cat)
	  {
	    return searchNearBy.searchNearBy(at, cat);
	  }

}

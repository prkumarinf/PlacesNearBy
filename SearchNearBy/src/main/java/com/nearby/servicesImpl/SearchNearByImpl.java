package com.nearby.servicesImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.nearby.constant.ApplicationConstant;
import com.nearby.model.Items;
import com.nearby.services.SearchNearBy;

@Service
public class SearchNearByImpl implements SearchNearBy{

	@Override
   //@Cacheable(value="searchItemsList", key="#p0")
	public List<Items> searchNearBy(String at, String cat) {
		// TODO Auto-generated method stub
		final String uri = "https://places.ls.hereapi.com/places/v1/discover/explore";
		String type = cat;

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri)
				.queryParam("at", at)
				.queryParam("cat", cat)
				.queryParam("app_id", ApplicationConstant.APP_ID)
				.queryParam("app_code", ApplicationConstant.APP_CODE);

		HttpEntity<?> entity = new HttpEntity<>(headers);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
		List<String> list = new ArrayList<>();
		List<Items> itemsList = new ArrayList<>();
		JSONObject resObj = new JSONObject(response.getBody());
		Iterator<?> keys = resObj.keys();
		while(keys.hasNext() ) {
		    String key = (String)keys.next();
		    if ( (resObj.get(key) instanceof JSONObject) && key.equals("results")) {
		        JSONObject jsonObj = new JSONObject(resObj.get(key).toString());
		        Iterator<?> subKeys = jsonObj.keys();
		        while(subKeys.hasNext() ) {
				    String subKey = (String)subKeys.next();
				    if ((jsonObj.get(subKey) instanceof Object) && subKey.equals("items")) {
				        JSONArray jArray = (JSONArray)jsonObj.get(subKey); 
				        if (jArray != null) { 
				           for (int i=0;i<jArray.length();i++){ 
				        	   list.add(jArray.get(i).toString());
				           } 
				        } 
				    }
				}
		    }
		}
		for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            JSONObject jsonObj = new JSONObject(str);
            Iterator<?> kys = jsonObj.keys();
            Items item = new Items();
    		while(kys.hasNext() ) {
    		    String key = (String)kys.next();
    		    if(key.equals("distance")) {
    		    	item.setDistance(String.valueOf(jsonObj.get(key)));
    		    }
    		    if(key.equals("title")) {
    		    	item.setTitle((String)jsonObj.get(key));
    		    }
    		    item.setType(type);
    		}
    		itemsList.add(item);
        }
		itemsList.forEach(System.out::println);
		return itemsList;
	}

}

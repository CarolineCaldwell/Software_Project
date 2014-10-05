package template.controllers;

import org.springframework.web.client.RestTemplate;
import template.controllers.Info;

public class LocationAPIPage {
	
	public static Info callGeocoding(String local[]) {
		RestTemplate restTemplate = new RestTemplate();
		StringBuilder location = new StringBuilder();
		StringBuilder website = new StringBuilder();
		
		if (local[0].matches("[0-9]") ) {
			location.append(local[0]);
		} else {
			location.append(local[0].replace("\\s+", "+"));
			location.append("+");
			location.append(local[1].replace("\\s+", "+"));
		}
		
		website.append("https://maps.googleapis.com/maps/api/geocode/json?"
				+ "key=AIzaSyCtP4-JNtbuW84Z56kgpQRbz93l0EljmN8&address=" + location);
		
		String site = website.toString();
		
		Info information = restTemplate.getForObject(site, Info.class);
		return information;
		
	}
}
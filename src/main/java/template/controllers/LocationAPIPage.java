package template.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

import template.controllers.Info;
import template.framework.objects.*;

public class LocationAPIPage {
	
	public Info callGeocoding(UserOptions options) throws  IOException, JSONException {
		
		StringBuilder location = new StringBuilder();
		StringBuilder website = new StringBuilder();
		
		if (options.getLocationName().matches("[0-9]*") ) {
			location.append(options.getLocationName());
		} else {
			String name = options.getLocationName().replaceAll(",", "");
			location.append(name.replaceAll("\\s", "+"));
		}
		
		website.append("https://maps.googleapis.com/maps/api/geocode/json?"
				+ "key=AIzaSyCtP4-JNtbuW84Z56kgpQRbz93l0EljmN8&address=" + location);
		
		String site = website.toString();
		URL url = new URL(site);
		Scanner scan = new Scanner(url.openStream());
		String content = new String();
		while (scan.hasNext())
			content += scan.nextLine();
		scan.close();
		
		JSONObject obj = new JSONObject(content);
		JSONObject results = obj.getJSONArray("results").getJSONObject(0);
		
		JSONObject locationValue = results.getJSONObject("geometry").getJSONObject("location");
		
		Info information = new Info();  
		
		Double value = locationValue.getDouble("lat");		
		information.setLat(String.valueOf(value));
		value = locationValue.getDouble("lng");
		information.setLng(String.valueOf(value));
		
		information.setLocation(location.toString());

		return information;
		
	}
}
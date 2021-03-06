package template.api;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

import template.framework.objects.*;

public class LocationAPIPage {
	
	public Info callGeocoding(UserOptions options) throws  IOException, JSONException {
		
		StringBuilder location = new StringBuilder();
		StringBuilder website = new StringBuilder();
		boolean isZip = false;
		
		if (options.getLocationName().matches("[0-9]*") ) {
			location.append(options.getLocationName());
			isZip = true;
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
		
		JSONObject component;
		
		if (isZip)
			component = results.getJSONArray("address_components").getJSONObject(3);
		else
			component = results.getJSONArray("address_components").getJSONObject(2);
		
		String stateAbbrev = component.getString("short_name");
		
		Info information = new Info();  
		
		Double value = locationValue.getDouble("lat");		
		information.setLat(String.valueOf(value));
		value = locationValue.getDouble("lng");
		information.setLng(String.valueOf(value));
		
		String locationSub = new String();
		
		if (!isZip)
		{
			if (location.lastIndexOf("+") != -1)
				locationSub = location.substring(0, location.lastIndexOf("+"));
			else
				locationSub = location.toString();
			
			information.setLocation(locationSub);
		}
		else
			information.setLocation(location.toString());
		
		information.setStateAbbrev(stateAbbrev);

		return information;
		
	}
}
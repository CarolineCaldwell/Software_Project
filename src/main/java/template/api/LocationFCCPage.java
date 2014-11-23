package template.api;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;
//import org.springframework.web.client.RestTemplate;


import template.framework.objects.Info;


public class LocationFCCPage {
	
	public Info callFCC(Info coordinates) throws JSONException, IOException {
		
		StringBuilder website = new StringBuilder();
		website.append("http://data.fcc.gov/api/block/find?format=json&latitude=");
		website.append(coordinates.getLat() + "&longitude=");
		website.append(coordinates.getLng() + "&showall=true");
		
		String site = website.toString();
		URL url = new URL(site);
		Scanner scan = new Scanner(url.openStream());
		String content = new String();
		while (scan.hasNext())
			content += scan.nextLine();
		scan.close();
		
		JSONObject obj = new JSONObject(content);
		JSONObject results = obj.getJSONObject("Block");
		
		String value = results.getString("FIPS");
		
		coordinates.setFIPS(value);
		
		String state = value.substring(0, 2);
		coordinates.setState(state);
		String county = value.substring(2, 5);
		coordinates.setCounty(county);
		String tract = value.substring(5, 11);
		coordinates.setTract(tract);
		
		return coordinates;
	}
}
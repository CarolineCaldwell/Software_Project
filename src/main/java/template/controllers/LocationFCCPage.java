package template.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;
//import org.springframework.web.client.RestTemplate;

import template.controllers.Info;


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
		
		System.out.println(content);
		
		JSONObject obj = new JSONObject(content);
		JSONObject results = obj.getJSONObject("Block");
		
		String value = results.getString("FIPS");
		
		coordinates.setFIPS(value);
		
		return coordinates;
	}
}
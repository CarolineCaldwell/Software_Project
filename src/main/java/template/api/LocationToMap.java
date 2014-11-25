package template.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

import template.algorithm.ApiResults;
import template.framework.objects.Info;

public class LocationToMap {

	public void mapToLocation (Info info, ApiResults allResults[]) throws IOException, JSONException {
		
		System.out.println(allResults.length);
		StringBuilder website = new StringBuilder();
		website.append("http://www.broadbandmap.gov/broadbandmap/census/tract/fips/");
		website.append(info.getState());
		website.append(info.getCounty());
		
		for (int a = 0; a < allResults.length; a++)
		{
			String fullWebsite = website.toString();
			fullWebsite += allResults[a].getTract();
			fullWebsite += "?format=json";
			
			URL url = new URL(fullWebsite);
			Scanner scan = new Scanner(url.openStream());
			String content = new String();
			while (scan.hasNext())
				content += scan.nextLine();
			scan.close();
			
			JSONObject obj = new JSONObject(content);
			JSONObject results = obj.getJSONObject("Results");
			JSONObject censusTract = results.getJSONArray("censusTract").getJSONObject(0);
			JSONObject location = censusTract.getJSONObject("envelope");
			
			double minX = location.getDouble("minx");
			double minY = location.getDouble("miny");
			double maxX = location.getDouble("maxx");
			double maxY = location.getDouble("maxy");
			
			double centerX = (minX + maxX) / 2;
			double centerY = (minY + maxY) / 2;
			double radius  = (maxY - minY) / 2;
			radius = (radius * 364560) / 5280;
			
			allResults[a].setCenterX(centerX);
			allResults[a].setCenterY(centerY);
			allResults[a].setRadius(radius);
		}
	}
}

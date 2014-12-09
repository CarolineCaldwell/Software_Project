package template.api;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import template.framework.objects.*;

public class MarriedAPIPage {
	
	public void callMarried(Info info, UserOptions options) throws IOException {
		
		String marriedStatus = options.getRelationshipStatus();
		
		StringBuilder totalNotMarried = new StringBuilder();
		StringBuilder totalMarried = new StringBuilder();
		
		// This is the API call for the total income in the area
		totalMarried.append("http://api.census.gov/data/2011/acs5?key=0de347d577c507172cd64a8375d2234674506014&get=B11001_001E"
							+ "&for=tract:*&in=state:" + info.getState()
							+ "+county:" + info.getCounty());
		
		// This is the API call for the total income in the area
		totalNotMarried.append("http://api.census.gov/data/2011/acs5?key=0de347d577c507172cd64a8375d2234674506014&get=B11001_003E"
							+ "&for=tract:*&in=state:" + info.getState()
							+ "+county:" + info.getCounty());
		
		String totalSite = totalMarried.toString();
		
		URL totalUrl = new URL(totalSite);
		Scanner totalScan = new Scanner(totalUrl.openStream());
		String totalContent = new String();
		while (totalScan.hasNext()) 
			totalContent += totalScan.nextLine();
		totalScan.close();
		info.setTotalMarriedResults(totalContent);
		
		String totalNotMarriedSite = totalNotMarried.toString();
		
		URL totalNotMarriedUrl = new URL(totalNotMarriedSite);
		Scanner totalNotMarriedScan = new Scanner(totalNotMarriedUrl.openStream());
		String totalNotMarriedContent = new String();
		while (totalNotMarriedScan.hasNext()) 
			totalNotMarriedContent += totalNotMarriedScan.nextLine();
		totalNotMarriedScan.close();
		info.setTotalNotMarriedResults(totalNotMarriedContent);
		
		
	}
}
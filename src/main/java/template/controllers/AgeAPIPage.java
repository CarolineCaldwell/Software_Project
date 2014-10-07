package template.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import template.controllers.Info;
import template.framework.objects.*;

public class AgeAPIPage {
	
	public void callAge(Info info, UserOptions options) throws IOException {
		
		String age = options.getAge();
		
		StringBuilder website = new StringBuilder();
		StringBuilder totalAges = new StringBuilder();
		StringBuilder basicSite = new StringBuilder();
		
		// These are for the API calls within switch
		website.append("http://api.census.gov/data/2011/acs5?get=B19037_");
		basicSite.append("&for=block+group:*&in=state:" + info.getState());
		basicSite.append("+county:" + info.getCounty() + "+tract:" + info.getTract());
		
		// This is the API call for the age in the area
		totalAges.append("http://api.census.gov/data/2011/acs5?get=B19037_001E"
							+ "&for=block+group:*&in=state:" + info.getState()
							+ "+county:" + info.getCounty() + "+tract:" + info.getTract());
		
		String totalSite = totalAges.toString();
				
		URL totalUrl = new URL(totalSite);
		Scanner totalScan = new Scanner(totalUrl.openStream());
		String totalContent = new String();
		while (totalScan.hasNext()) 
			totalContent += totalScan.nextLine();
		totalScan.close();
		info.setTotalAgeResults(totalContent);
		
		String ageBracket = new String();
		
		// Switch calls API based on age range provided 
		switch(age) {
			case "0-24":	String call01 = website.toString();
							call01 += "002E";
							call01 += basicSite.toString();
							URL call01Url = new URL(call01);
							Scanner scan01 = new Scanner(call01Url.openStream());
							while (scan01.hasNext()) 
								ageBracket += scan01.nextLine();
							scan01.close();
							
			case "25-44":	String call02 = website.toString();
							call02 += "019E";
							call02 += basicSite.toString();
							URL call02Url = new URL(call02);
							Scanner scan02 = new Scanner(call02Url.openStream());
							while (scan02.hasNext()) 
								ageBracket += scan02.nextLine();
							scan02.close();
							
			case "45-64":	String call03 = website.toString();
							call03 += "036E";
							call03 += basicSite.toString();
							URL call03Url = new URL(call03);
							Scanner scan03 = new Scanner(call03Url.openStream());
							while (scan03.hasNext()) 
								ageBracket += scan03.nextLine();
							scan03.close();
							
			case "65+":		String call04 = website.toString();
							call04 += "053E";
							call04 += basicSite.toString();
							URL call04Url = new URL(call04);
							Scanner scan04 = new Scanner(call04Url.openStream());
							while (scan04.hasNext()) 
								ageBracket += scan04.nextLine();
							scan04.close();	
		}
		
		info.setAgeBracketResults(ageBracket);
	}
}
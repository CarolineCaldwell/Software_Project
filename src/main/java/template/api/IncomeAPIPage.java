package template.api;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import template.framework.objects.*;

public class IncomeAPIPage {
	
	public void callIncome(Info info, UserOptions options) throws IOException {
		
		String income = options.getIncome();
		
		StringBuilder website = new StringBuilder();
		StringBuilder totalIncome = new StringBuilder();
		StringBuilder basicSite = new StringBuilder();
		
		// These are for the API calls within switch
		website.append("http://api.census.gov/data/2011/acs5?key=0de347d577c507172cd64a8375d2234674506014&get=B19001_");
		basicSite.append("&for=tract:*&in=state:" + info.getState());
		basicSite.append("+county:" + info.getCounty());
		
		// This is the API call for the total income in the area
		totalIncome.append("http://api.census.gov/data/2011/acs5?key=0de347d577c507172cd64a8375d2234674506014&"
							+ "get=B19001_001E&for=tract:*&in=state:" + info.getState()
							+ "+county:" + info.getCounty());
		
		String totalSite = totalIncome.toString();
				
		URL totalUrl = new URL(totalSite);
		Scanner totalScan = new Scanner(totalUrl.openStream());
		String totalContent = new String();
		while (totalScan.hasNext()) 
			totalContent += totalScan.nextLine();
		totalScan.close();
		info.setTotalIncomeResults(totalContent);
		
		String incomeBracket = new String();
		
		// Switch calls different APIs based on income range provided
		switch (income) {
			case "0-25":	
							String call01 = website.toString();
							call01 += "002E";
							call01 += basicSite.toString();
							URL call01Url = new URL(call01);
							Scanner scan01 = new Scanner(call01Url.openStream());
							while (scan01.hasNext()) 
								incomeBracket += scan01.nextLine();
							scan01.close();
							
							String call02 = website.toString();
							call02 += "003E";
							call02 += basicSite.toString();
							URL call02Url = new URL(call02);
							Scanner scan02 = new Scanner(call02Url.openStream());
							while (scan02.hasNext()) 
								incomeBracket += scan02.nextLine();
							scan02.close();
							
							String call03 = website.toString();
							call03 += "004E";
							call03 += basicSite.toString();
							URL call03Url = new URL(call03);
							Scanner scan03 = new Scanner(call03Url.openStream());
							while (scan03.hasNext()) 
								incomeBracket += scan03.nextLine();
							scan03.close();
							
							String call04 = website.toString();
							call04 += "005E";
							call04 += basicSite.toString();
							URL call04Url = new URL(call04);
							Scanner scan04 = new Scanner(call04Url.openStream());
							while (scan04.hasNext()) 
								incomeBracket += scan04.nextLine();
							scan04.close();
							break;
							
			case "25-50":	String call05 = website.toString();
							call05 += "006E";
							call05 += basicSite.toString();
							URL call05Url = new URL(call05);
							Scanner scan05 = new Scanner(call05Url.openStream());
							while (scan05.hasNext()) 
								incomeBracket += scan05.nextLine();
							scan05.close();
							
							String call06 = website.toString();
							call06 += "007E";
							call06 += basicSite.toString();
							URL call06Url = new URL(call06);
							Scanner scan06 = new Scanner(call06Url.openStream());
							while (scan06.hasNext()) 
								incomeBracket += scan06.nextLine();
							scan06.close();
							
							String call07 = website.toString();
							call07 += "008E";
							call07 += basicSite.toString();
							URL call07Url = new URL(call07);
							Scanner scan07 = new Scanner(call07Url.openStream());
							while (scan07.hasNext()) 
								incomeBracket += scan07.nextLine();
							scan07.close();
							
							String call08 = website.toString();
							call08 += "009E";
							call08 += basicSite.toString();
							URL call08Url = new URL(call08);
							Scanner scan08 = new Scanner(call08Url.openStream());
							while (scan08.hasNext()) 
								incomeBracket += scan08.nextLine();
							scan08.close();
							
							String call09 = website.toString();
							call09 += "010E";
							call09 += basicSite.toString();
							URL call09Url = new URL(call09);
							Scanner scan09 = new Scanner(call09Url.openStream());
							while (scan09.hasNext()) 
								incomeBracket += scan09.nextLine();
							scan09.close();
							break;
							
			case "50-75":	String call10 = website.toString();
							call10 += "011E";
							call10 += basicSite.toString();
							URL call10Url = new URL(call10);
							Scanner scan10 = new Scanner(call10Url.openStream());
							while (scan10.hasNext()) 
								incomeBracket += scan10.nextLine();
							scan10.close();
							
							String call11 = website.toString();
							call11 += "012E";
							call11 += basicSite.toString();
							URL call11Url = new URL(call11);
							Scanner scan11 = new Scanner(call11Url.openStream());
							while (scan11.hasNext()) 
								incomeBracket += scan11.nextLine();
							scan11.close();
							break;
							
			case "75-100":	String call12 = website.toString();
							call12 += "013E";
							call12 += basicSite.toString();
							URL call12Url = new URL(call12);
							Scanner scan12 = new Scanner(call12Url.openStream());
							while (scan12.hasNext()) 
								incomeBracket += scan12.nextLine();
							scan12.close();
							break;
							
			case "100+":	String call13 = website.toString();
							call13 += "014E";
							call13 += basicSite.toString();
							URL call13Url = new URL(call13);
							Scanner scan13 = new Scanner(call13Url.openStream());
							while (scan13.hasNext()) 
								incomeBracket += scan13.nextLine();
							scan13.close();
							
							String call14 = website.toString();
							call14 += "015E";
							call14 += basicSite.toString();
							URL call14Url = new URL(call14);
							Scanner scan14 = new Scanner(call14Url.openStream());
							while (scan14.hasNext()) 
								incomeBracket += scan14.nextLine();
							scan14.close();
							
							String call15 = website.toString();
							call15 += "016E";
							call15 += basicSite.toString();
							URL call15Url = new URL(call15);
							Scanner scan15 = new Scanner(call15Url.openStream());
							while (scan15.hasNext()) 
								incomeBracket += scan15.nextLine();
							scan15.close();
							
							String call16 = website.toString();
							call16 += "017E";
							call16 += basicSite.toString();
							URL call16Url = new URL(call16);
							Scanner scan16 = new Scanner(call16Url.openStream());
							while (scan16.hasNext()) 
								incomeBracket += scan16.nextLine();
							scan16.close();
							break;
							
			default:		break;
		}
		
		info.setIncomeBracketResults(incomeBracket);
	}
}
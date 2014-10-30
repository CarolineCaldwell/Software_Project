package template.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import template.controllers.Info;
import template.framework.objects.*;

public class EducationAPIPage {
	
	public void callEducation(Info info, UserOptions options) throws IOException {
		
		String education = options.getSchoolImportance();
		
		StringBuilder website = new StringBuilder();
		
		website.append("http://api.education.com/service/service.php?f=getTestRating&Resf=json&"
						+ "key=8f222f04d7c956ea55a62c50640765fa&sn=sf&v=4&");
		
		if (info.getLocation().matches("[0-9]*") ) 
			website.append("zip=" + info.getLocation());
		else 
			website.append("city=" + info.getLocation());
		
		String site = website.toString();
		URL url = new URL(site);
		Scanner scan = new Scanner(url.openStream());
		String content = new String();
		while (scan.hasNext())
			content += scan.nextLine();
		scan.close();
		
		info.setEducationResults(content);
	}
}
package template.api;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import template.framework.objects.*;

public class EducationAPIPage {
	
	public void callEducation(Info info, UserOptions options) throws IOException {
		
		StringBuilder website = new StringBuilder();
		
		website.append("http://api.education.com/service/service.php?f=getTestRating&Resf=json&"
						+ "key=5db6f572df259798a2af42edcbc125ba&sn=sf&v=4&"); // Lab 113 - Teacher's Computer
						/*+ "key=6b1b07ef4acd2685928c44cbc517e22b&sn=sf&v=4&");*/ // Lab 214 - SDL05
						/*+ "key=5c24aa159693eb8fe46c8e075e347879&sn=sf&v=4&");*/ // Lab 214 - SDL14
						/*+ "key=7733fc813d58fafdb89c995170cf481d&sn=sf&v=4&");*/ // Lab 113 - ACS13
		
		if (info.getLocation().matches("[0-9]*") ) 
			website.append("zip=" + info.getLocation());
		else 
		{
			website.append("city=" + info.getLocation());
			website.append("&state=" + info.getStateAbbrev());
		}
		
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
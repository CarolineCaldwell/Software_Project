package template.interaction;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApiConnection {
	public String callApi()
	{
		try {
		    URL myURL = new URL("http://api.census.gov/data/2011/acs5?key=0de347d577c507172cd64a8375d2234674506014&get=B992519_001E,NAME&for=county:*&in=state:048");
		    URLConnection myURLConnection = myURL.openConnection();
		    myURLConnection.connect();
		} 
		catch (MalformedURLException e) { 
		    // new URL() failed
		    // ...
		} 
		catch (IOException r) {   
		    // openConnection() failed
		    // ...
		}
		return "DERP";
	}
}

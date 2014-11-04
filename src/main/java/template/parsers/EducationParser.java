package template.parsers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import template.algorithm.ApiResults;
import template.controllers.Info;

public class EducationParser {

	public void parseEducation(Info info, ApiResults [] allResults) throws JSONException {
		
		String educationResults = info.getEducationResults();
		String [] schoolResults = educationResults.split(":");
		
		for (int i = 0; i < schoolResults.length; i++)
		{
			System.out.println(schoolResults[i].length() + " | " + schoolResults[i]);
			
			System.out.println(schoolResults[i].substring(0, 13).equals("\"Education.com "));
			//if (schoolResults[i].substring(0, 14).equals("\"Education.com"))
			//	System.out.println(schoolResults[i]);
		}

	}
}

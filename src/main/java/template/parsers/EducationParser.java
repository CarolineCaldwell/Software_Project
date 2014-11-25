package template.parsers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import template.algorithm.ApiResults;
import template.framework.objects.Info;

public class EducationParser {

	public void parseEducation(Info info, ApiResults [] allResults) throws JSONException {
		
		String educationResults = info.getEducationResults();
		
		JSONArray obj = new JSONArray(educationResults);
		int[] allScores = new int [obj.length()];
		int intScore;
		
		for (int i = 0; i < obj.length(); i++)
		{
			JSONObject schoolObj = obj.getJSONObject(i).getJSONObject("school");
			String score = schoolObj.getString("testrating_text");
			if (score.equals(""))
			{
				intScore = -1;
			}
			else
			{
				score = score.substring(score.length() -1);
				intScore = Integer.parseInt(score);
			}
			allScores[i] = intScore;
		}
		
		for (int a = 0; a < allResults.length; a++)
			allResults[a].setSchool(allScores);
	}
}

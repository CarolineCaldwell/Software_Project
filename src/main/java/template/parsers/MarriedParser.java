package template.parsers;

import template.algorithm.ApiResults;
import template.framework.objects.Info;

public class MarriedParser {
	
	public void parseMarried(Info info, ApiResults [] allResults) {
		
		String totalMarried = info.getTotalMarriedResults();
		String totalNotMarried = info.getTotalNotMarriedResults();
		
		String [] marriedArray = totalMarried.split(",");
		String [] notMarriedArray = totalNotMarried.split(",");
		
		int resultIndex = 0;
		
		for (int i = 4; i < marriedArray.length; i++)
		{
			if (marriedArray[i].substring(0,2).equals( "[\""))
			{
				String total = marriedArray[i].substring(2, marriedArray[i].length()-1);
				int temp = Integer.parseInt(total);
				allResults[resultIndex].setRelationTotal(temp);				
			}
		}
		
		resultIndex = 0;
		for (int i = 0; i < notMarriedArray.length; i++)
		{
			if (notMarriedArray[i].substring(0,2).equals( "[\""))
			{
				String bracket = notMarriedArray[i].substring(2, notMarriedArray[i].length()-1);
				int temp = Integer.parseInt(bracket);
				allResults[resultIndex].setRelation(temp);
				resultIndex++;
				
				if (resultIndex == allResults.length)
					resultIndex = 0;
			}
		}
	}

}

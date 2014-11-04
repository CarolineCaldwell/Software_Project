package template.parsers;

import template.algorithm.ApiResults;
import template.controllers.Info;

public class AgeParser {
	
	public void parseAge(Info info, ApiResults [] allResults) {
		
		String totalAge = info.getTotalAgeResults();
		String bracketAge = info.getAgeBracketResults();
		
		String [] totalArray = totalAge.split(",");
		String [] bracketArray = bracketAge.split(",");
		
		int resultIndex = 0;
		
		for (int i = 4; i < totalArray.length; i++)
		{
			if (totalArray[i].substring(totalArray[i].length()-2).equals( "\"]"))
			{
				String tract = totalArray[i].substring(1,totalArray[i].length()-2);
				int temp = Integer.parseInt(tract);
				allResults[resultIndex].setTract(temp);
				resultIndex++;
			}
			else if (totalArray[i].substring(totalArray[i].length()-3).equals( "\"]]"))
			{
				String tract = totalArray[i].substring(1,totalArray[i].length()-3);
				int temp = Integer.parseInt(tract);
				allResults[resultIndex].setTract(temp);
				resultIndex++;
			}
			else if (totalArray[i].substring(0,2).equals( "[\""))
			{
				String total = totalArray[i].substring(2, totalArray[i].length()-1);
				int temp = Integer.parseInt(total);
				allResults[resultIndex].setAgeTotal(temp);			
			}
		}
		
		resultIndex = 0;
		for (int i = 0; i < bracketArray.length; i++)
		{
			if (bracketArray[i].substring(0,2).equals( "[\""))
			{
				String bracket = bracketArray[i].substring(2, bracketArray[i].length()-1);
				int temp = Integer.parseInt(bracket);
				temp += allResults[resultIndex].getAge();
				allResults[resultIndex].setAge(temp);
				resultIndex++;
				
				if (resultIndex == allResults.length)
					resultIndex = 0;
			}
		}		
	}

}

package template.parsers;

import org.json.JSONException;

import template.algorithm.ApiResults;
import template.controllers.Info;
import template.framework.objects.UserOptions;

public class IncomeParser {

	public ApiResults[] parseIncome(Info info, UserOptions options) throws JSONException {
		
		String totalIncome = info.getTotalIncomeResults();
		String bracketIncome = info.getIncomeBracketResults();
		
		String[] totalArray = totalIncome.split(",");
		String[] bracketArray = bracketIncome.split(",");
		
		ApiResults allResults [] = new ApiResults [totalArray.length / 4 - 1];
		int resultIndex = 0;		
		
		System.out.println(allResults.length);
		
		for (int i = totalArray.length-1; i >= 0 ; i--)
		{
			if (totalArray[i].substring(totalArray[i].length()-2).equals( "\"]") ||
				totalArray[i].substring(totalArray[i].length()-2).equals( "\"]]"))
			{
				String tract = totalArray[i].substring(1,totalArray[i].length()-2);
				if (tract.equals("tract"))
					continue;
				int temp = Integer.parseInt(tract);
				allResults[resultIndex].setTract(temp);
				resultIndex++;
			}
			else if (totalArray[i].substring(0,2).equals( "[\""))
			{
				String total = totalArray[i].substring(2, totalArray[i].length()-1);
				int temp = Integer.parseInt(total);
				ApiResults apiResult = new ApiResults();
				apiResult.setIncomeTotal(temp);
				allResults[resultIndex] = apiResult;				
			}
		}
		
		String option = options.getIncome();
		int numQueries = 0;
		switch(option)
		{
			case "0-25":	numQueries = 4;
							break;
			case "25-50":	numQueries = 5;
							break;
			case "50-75":	numQueries = 2;
							break;
			case "75-100":	numQueries = 1;
							break;
			case "100+":	numQueries = 4;
							break;
		}
		
		for (int j = 0; j < numQueries; j++)
		{
			resultIndex = 0;
			for (int i = 0; i < bracketArray.length; i++)
			{
				if (bracketArray[i].substring(0,2).equals( "[\""))
				{
					String bracket = bracketArray[i].substring(2, bracketArray[i].length()-1);
					int temp = Integer.parseInt(bracket);
					temp += allResults[resultIndex].getIncome();
					allResults[resultIndex].setIncome(temp);
					resultIndex++;
				}
			}
		}		
		
		//System.out.println(allResults.length);
			for (int j = 0; j < allResults.length; j++)
			{
				System.out.println(allResults[j].getTract() + ", " + allResults[j].getIncomeTotal() + ", " + allResults[j].getIncome());
			}
		return allResults;
	}
}

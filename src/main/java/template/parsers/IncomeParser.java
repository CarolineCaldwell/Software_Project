package template.parsers;

import template.algorithm.ApiResults;
import template.framework.objects.Info;

public class IncomeParser {

	public ApiResults[] parseIncome(Info info) {
		
		String totalIncome = info.getTotalIncomeResults();
		String bracketIncome = info.getIncomeBracketResults();
		
		String[] totalArray = totalIncome.split(",");
		String[] bracketArray = bracketIncome.split(",");
		
		ApiResults allResults [] = new ApiResults [totalArray.length / 4 -1];
		int resultIndex = 0;		
		
		for (int i = 4; i < totalArray.length; i++)
		{
			if (totalArray[i].substring(totalArray[i].length()-2).equals( "\"]"))
			{
				String tract = totalArray[i].substring(1,totalArray[i].length()-2);
				allResults[resultIndex].setTract(tract);
				resultIndex++;
			}
			else if (totalArray[i].substring(totalArray[i].length()-3).equals( "\"]]"))
			{
				String tract = totalArray[i].substring(1,totalArray[i].length()-3);
				allResults[resultIndex].setTract(tract);
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
				
				if (resultIndex == allResults.length)
					resultIndex = 0;
			}
		}	
		
		return allResults;
	}
}

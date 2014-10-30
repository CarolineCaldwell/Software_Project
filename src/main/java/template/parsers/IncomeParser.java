package template.parsers;

import template.algorithm.ApiResults;
import template.controllers.Info;

public class IncomeParser {

	public void parseIncome(Info info, ApiResults results) {
		
		String totalIncome = info.getTotalIncomeResults();
		String bracketIncome = info.getIncomeBracketResults();
		
		String[] totalArray = totalIncome.split(",");
		String[] bracketArray = bracketIncome.split(",");
		
		for (int i = 0; i < totalArray.length; i++)
				System.out.println(totalArray[i]);
		for (int i = 0; i < bracketArray.length; i++)
			System.out.println(bracketArray[i]);
	}
}

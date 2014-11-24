package template.parsers;

import java.util.Arrays;

import template.algorithm.ApiResults;

public class AreaParser {
	
	public void parseArea(ApiResults [] allResults) {
		
		int totalPop = 0;
		int thirdPop = 0;
		int countPop = 0;
		int allPops[] = new int [allResults.length];
		
		for (int i = 0; i < allResults.length; i++) {
			totalPop += allResults[i].getIncomeTotal();
			allPops[i] = allResults[i].getIncomeTotal();
		}
		
		Arrays.sort(allPops);
		thirdPop = totalPop / 3;
		String type [] = {"City", "Suburban", "Rural"};
		int typeIndex = 0;
		int index = 0;
		
		for (int j = allPops.length - 1; j >= 0 ; j--)
		{		
			// Update area type
			if (countPop >= thirdPop && countPop < (thirdPop * 2))
				typeIndex = 1;
			else if (countPop >= (thirdPop * 2))
				typeIndex = 2;
			
			index = 0;
			while (allResults[index].getIncomeTotal() != allPops[j] || !allResults[index].getAreaType().isEmpty())
				index++;
			
			allResults[index].setAreaType(type[typeIndex]);
			countPop += allPops[j];	
		}
	}

}

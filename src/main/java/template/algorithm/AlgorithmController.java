package template.algorithm;

public class AlgorithmController
{
		
	
	
	public int generateAlgorithm(ApiResults results)
	{
		int score = 0;
		int weightSum = 0;
		
		if(results.isIncomeIncluded())
		{
			score += incomeAlgorithm(results);
			weightSum += results.getIncomeWeight();
		}
		
		if(results.isRelationIncluded())
		{
			score += relationAlgorithm(results);
			weightSum += results.getRelationWeight();
		}
		
		if(results.isAgeIncluded())
		{
			score += ageAlgorithm(results);
			weightSum += results.getAgeWeight();
		}
		
		if(results.isSchoolIncluded())
		{
			score += schoolAlgorithm(results);
			weightSum += results.getSchoolWeight();
		}
		
		
		return score/weightSum;
	}
	
	private int incomeAlgorithm(ApiResults results)
	{		
		return results.getIncome()/results.getIncomeTotal()
			   *results.getIncomeWeight();
	}
	
	private int relationAlgorithm(ApiResults results)
	{
		return results.getRelation()/results.getRelationTotal()
			   *results.getRelationWeight();
	}
	
	private int ageAlgorithm(ApiResults results)
	{
		return results.getAge()/results.getAgeTotal()
			   *results.getAgeWeight();
	}
	
	private int schoolAlgorithm(ApiResults results)
	{
		int count = 0;
		int sum = 0;
		for(int school : results.getSchool())
		{
			sum += school;
			count++;
		}
			
		return sum/count*results.getSchoolWeight();
	}

	
	
	
}

package template.algorithm;

public class AlgorithmController
{
	
	public void generateAlgorithm(ApiResults results, ApiImportance apiStatic)
	{
		int score = 0;
		int weightSum = 0;
		
		if(apiStatic.isIncomeIncluded())
		{
			score += incomeAlgorithm(results, apiStatic);
			weightSum += apiStatic.getIncomeWeight();
		}
		
		if(apiStatic.isRelationIncluded())
		{
			score += relationAlgorithm(results, apiStatic);
			weightSum += apiStatic.getRelationWeight();
		}
		
		if(apiStatic.isAgeIncluded())
		{
			score += ageAlgorithm(results, apiStatic);
			weightSum += apiStatic.getAgeWeight();
		}
		
		if(apiStatic.isSchoolIncluded())
		{
			score += schoolAlgorithm(results, apiStatic);
			weightSum += apiStatic.getSchoolWeight();
		}
		
		results.setAlgorithmValue(score/weightSum);
	}
	
	private int incomeAlgorithm(ApiResults results, ApiImportance apiStatic)
	{		
		return results.getIncome()/results.getIncomeTotal()
			   *apiStatic.getIncomeWeight();
	}
	
	private int relationAlgorithm(ApiResults results, ApiImportance apiStatic)
	{
		return results.getRelation()/results.getRelationTotal()
			   *apiStatic.getRelationWeight();
	}
	
	private int ageAlgorithm(ApiResults results, ApiImportance apiStatic)
	{
		return results.getAge()/results.getAgeTotal()
			   *apiStatic.getAgeWeight();
	}
	
	private int schoolAlgorithm(ApiResults results, ApiImportance apiStatic)
	{
		int count = 0;
		int sum = 0;
		for(int school : results.getSchool())
		{
			sum += school;
			count++;
		}
			
		return sum/count*apiStatic.getSchoolWeight();
	}
	
}

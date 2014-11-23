package template.algorithm;

public class AlgorithmController
{
	public void AlgorithmController()
	{
		
	}
	
	public void generateAlgorithm(ApiResults results, ApiImportance apiStatic)
	{
		double score = 0;
		double weightSum = 0;
		
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
		
		//System.out.println("In Alg: " + score/weightSum);
		
		results.setAlgorithmValue(score/weightSum);
	}
	
	private double incomeAlgorithm(ApiResults results, ApiImportance apiStatic)
	{	
		if(results.getIncomeTotal() == 0)
			return 0;
		
		double value = results.getIncome();
		value = value / results.getIncomeTotal();
		value = value * apiStatic.getIncomeWeight();
		return value;
	}
	
	private double relationAlgorithm(ApiResults results, ApiImportance apiStatic)
	{
		if(results.getRelationTotal() == 0)
			return 0;
		double value;
		if(apiStatic.getRelationStatus() == "Single")
		{
			value = results.getRelationTotal();
			value = value - results.getRelation();
			value = value / results.getRelationTotal();
			value = value * apiStatic.getRelationWeight();
			return value;
		}	
		
		value = results.getRelation();
		value = value / results.getRelationTotal();
		value = value * apiStatic.getRelationWeight();
		return value;
	}
	
	private double ageAlgorithm(ApiResults results, ApiImportance apiStatic)
	{
		if(results.getAgeTotal() == 0)
			return 0;
		double value = results.getAge();
		value = value / results.getAgeTotal();
		value = value * apiStatic.getAgeWeight();
		
		return value;
	}
	
	private double schoolAlgorithm(ApiResults results, ApiImportance apiStatic)
	{
		double count = 0;
		double sum = 0;
		for(int school : results.getSchool())
		{
			if(school != -1)
			{
				sum += school;
				count++;
			}
		}
			
		return (sum/count*apiStatic.getSchoolWeight());
	}
	
}

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
		double value = 0;
		
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
		
		if(apiStatic.isAreaIncluded())
		{
			score += areaAlgorithm(results, apiStatic);
			weightSum += apiStatic.getAreaWeight();
		}
		
		
		
		if(weightSum == 0)
			value = 0;
		else
			value = score / weightSum;
		
		//System.out.println("In Alg: " + value);
		results.setAlgorithmValue(value);
	}
	
	private double incomeAlgorithm(ApiResults results, ApiImportance apiStatic)
	{	
		if(results.getIncomeTotal() == 0)
			return 0;
		
		double value = results.getIncome();
		value = value / results.getIncomeTotal();
		value = value * apiStatic.getIncomeWeight();
		//System.out.println(" Income: " + (value / apiStatic.getIncomeWeight()));
		return value;
	}
	
	private double relationAlgorithm(ApiResults results, ApiImportance apiStatic)
	{
		if(results.getRelationTotal() == 0)
			return 0;
		
		double value;
		
		if(apiStatic.getRelationStatus().equals("Single"))
		{
			value = results.getRelationTotal();
			value = value - results.getRelation();
			value = value / results.getRelationTotal();
			value = value * apiStatic.getRelationWeight();
			//System.out.println(" Relation: " + (value / apiStatic.getRelationWeight()));
			return value;
		}	
		
		value = results.getRelation();
		value = value / results.getRelationTotal();
		value = value * apiStatic.getRelationWeight();
		//System.out.println(" Relation: " + (value / apiStatic.getRelationWeight()));
		return value;
	}
	
	private double ageAlgorithm(ApiResults results, ApiImportance apiStatic)
	{
		if(results.getAgeTotal() == 0)
			return 0;
		
		double value = results.getAge();
		value = value / results.getAgeTotal();
		value = value * apiStatic.getAgeWeight();
		//System.out.println(" Age: " + (value / apiStatic.getAgeWeight()));
		return value;
	}
	
	private double schoolAlgorithm(ApiResults results, ApiImportance apiStatic)
	{
		double count = 0;
		double sum = 0;
		double value = 0;
		
		for(int school : results.getSchool())
		{
			if(school != -1)
			{
				sum += school;
				count++;
			}
		}
		
		if(count == 0)
			value = 0;
		else
			value = (sum/count) / 10 * apiStatic.getSchoolWeight();
		
		//System.out.println(" School: " + (value / 10 / apiStatic.getSchoolWeight()));
		return value;
	}
	
	private double areaAlgorithm(ApiResults results, ApiImportance apiStatic)
	{
		double value = 0;
		
		if(results.getAreaType().equals(apiStatic.getAreaType()))
			value = 1;
		else
			value = .75;
		
		value = value * apiStatic.getAreaWeight();
		//System.out.println(" Area: " + (value / apiStatic.getAreaWeight()));
		return value;
	}
	
}

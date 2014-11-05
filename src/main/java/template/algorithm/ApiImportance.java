package template.algorithm;

import template.framework.objects.UserOptions;

public class ApiImportance {
	private int incomeWeight;
	private int relationWeight;
	private String relationStatus;
	private int ageWeight;
	private int schoolWeight;
	
	public ApiImportance(UserOptions useroption)
	{
		try
		{
			//TODO PARSE stuff.
			incomeWeight = Integer.parseInt(useroption.getIncomeImportance());
			relationWeight = Integer.parseInt(useroption.getRelationshipStatusImportance());
			ageWeight = Integer.parseInt(useroption.getAgeImportance());
			schoolWeight = Integer.parseInt(useroption.getSchoolImportance());
			relationStatus = "Single";
		}
		catch(NumberFormatException e)
		{
			System.out.println("ERROR: Format error.");
		}
	}
	
	public boolean isIncomeIncluded()
	{
		if(incomeWeight == 0)
			return false;
		return true;
	}
	public boolean isRelationIncluded()
	{
		if(relationWeight == 0)
			return false;
		return true;
	}
	public boolean isAgeIncluded()
	{
		if(ageWeight == 0)
			return false;
		return true;
	}
	public boolean isSchoolIncluded()
	{
		if(schoolWeight == 0)
			return false;
		return true;
	}
	
	public int getIncomeWeight() {
		return incomeWeight;
	}
	public void setIncomeWeight(int incomeWeight) {
		this.incomeWeight = incomeWeight;
	}
	public int getRelationWeight() {
		return relationWeight;
	}
	public void setRelationWeight(int relationWeight) {
		this.relationWeight = relationWeight;
	}
	public int getAgeWeight() {
		return ageWeight;
	}
	public void setAgeWeight(int ageWeight) {
		this.ageWeight = ageWeight;
	}
	public int getSchoolWeight() {
		return schoolWeight;
	}
	public void setSchoolWeight(int schoolWeight) {
		this.schoolWeight = schoolWeight;
	}

	public String getRelationStatus() {
		return relationStatus;
	}

	public void setRelationStatus(String relationStatus) {
		this.relationStatus = relationStatus;
	}
	
	
}

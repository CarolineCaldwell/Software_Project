package template.algorithm;

public class ApiResults implements Comparable<ApiResults>
{
	private String tract;
	//private int population;
	private int income;
	private int incomeTotal;
	//private int incomeWeight;
	//private boolean incomeIncluded;
	private int relation;
	private int relationTotal;
	//private int relationWeight;
	//private boolean relationIncluded;
	private int age;
	private int ageTotal;
	//private int ageWeight;
	//private boolean ageIncluded;
	private int[] school;
	//private int schoolWeight;
	//private boolean schoolIncluded;
	private double algorithmValue;
	private String areaType;
	
	private double centerX;
	private double centerY;
	private double radius;
	
	public ApiResults() {
		tract = "";
		income = 0;
		incomeTotal = 0;
		//incomeWeight = 0;
		//incomeIncluded = true;
		relation = 0;
		relationTotal = 0;
		//relationWeight = 0;
		//relationIncluded = true;
		age = 0;
		ageTotal = 0;
		algorithmValue = 0;
		//ageWeight = 0;
		//ageIncluded = true;
		//schoolWeight = 0;
		//schoolIncluded = true;
		areaType = "";
		
		centerX = 0;
		centerY = 0;
		radius = 0;
	}
	
	public void copyResult(ApiResults a) {
		this.tract = a.getTract();
		this.income = a.getIncome();
		this.incomeTotal= a.getIncomeTotal();
		this.relation = a.getRelation();
		this.relationTotal = a.getRelationTotal();
		this.age = a.getAge();
		this.ageTotal = a.getAgeTotal();
		this.algorithmValue = a.getAlgorithmValue();
		this.areaType = a.getAreaType();
		this.centerX = a.getCenterX();
		this.centerY = a.getCenterY();
		this.radius = a.getRadius();
	}
	
	public String getTract() {
		return tract;
	}
	public void setTract(String tract) {
		this.tract = tract;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getIncomeTotal() {
		return incomeTotal;
	}
	public void setIncomeTotal(int incomeTotal) {
		this.incomeTotal = incomeTotal;
	}
	public int getRelation() {
		return relation;
	}
	public void setRelation(int relation) {
		this.relation = relation;
	}
	public int getRelationTotal() {
		return relationTotal;
	}
	public void setRelationTotal(int relationTotal) {
		this.relationTotal = relationTotal;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAgeTotal() {
		return ageTotal;
	}
	public void setAgeTotal(int ageTotal) {
		this.ageTotal = ageTotal;
	}
	public int[] getSchool() {
		return school;
	}
	public void setSchool(int[] school) {
		this.school = school;
	}
	public double getAlgorithmValue() {
		return algorithmValue;
	}
	public void setAlgorithmValue(double d) {
		this.algorithmValue = d;
	}
	public String getAreaType() {
		return areaType;
	}
	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}


	public double getCenterX() {
		return centerX;
	}


	public void setCenterX(double centerX) {
		this.centerX = centerX;
	}


	public double getCenterY() {
		return centerY;
	}


	public void setCenterY(double centerY) {
		this.centerY = centerY;
	}


	public double getRadius() {
		return radius;
	}


	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public int compareTo(ApiResults arg0) {
		
		if (this.getAlgorithmValue() < arg0.getAlgorithmValue())
			return 1;
		else if (this.getAlgorithmValue() > arg0.getAlgorithmValue())
			return -1;
		else
			return 0;
		//return (int) ((this.getAlgorithmValue()-arg0.getAlgorithmValue()) * 100);
	}
	
}


	

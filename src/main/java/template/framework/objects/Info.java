package template.framework.objects;

public class Info {
	
	private int    numTracts;
	//////////////////////////
	private String location;
	private String lng;
	private String lat;
	private String FIPS;
	private String state;
	private String county;
	private String tract;	// Currently not used
	//////////////////////////
	private String totalIncomeResults;
	private String incomeBracketResults;
	private String totalAgeResults;
	private String ageBracketResults;
	private String totalMarriedResults;
	private String totalNotMarriedResults;
	private String educationResults;
	
	public Info() {
		numTracts = 0;
		location = "";
		lat = "";
		lng = "";
		FIPS = "";
		state = "";
		county = "";
		tract = "";
		//////////////////////////
		totalIncomeResults = "";
		incomeBracketResults = "";
		totalAgeResults = "";
		ageBracketResults = "";
		totalMarriedResults = "";
		totalNotMarriedResults = "";
		educationResults = "";
	}
	
	public int getNumTracts() {
		return numTracts;
	}

	public void setNumTracts(int numTracts) {
		this.numTracts = numTracts;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}
	
	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getFIPS() {
		return FIPS;
	}

	public void setFIPS(String fIPS) {
		FIPS = fIPS;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getTract() {
		return tract;
	}

	public void setTract(String tract) {
		this.tract = tract;
	}

	// These are TEMPORARY FUNCTIONS!!!!
	
	public String getTotalIncomeResults() {
		return totalIncomeResults;
	}

	public void setTotalIncomeResults(String totalIncomeResults) {
		this.totalIncomeResults = totalIncomeResults;
	}

	public String getIncomeBracketResults() {
		return incomeBracketResults;
	}

	public void setIncomeBracketResults(String incomeBracketResults) {
		this.incomeBracketResults = incomeBracketResults;
	}

	public String getTotalAgeResults() {
		return totalAgeResults;
	}

	public void setTotalAgeResults(String totalAgeResults) {
		this.totalAgeResults = totalAgeResults;
	}

	public String getAgeBracketResults() {
		return ageBracketResults;
	}

	public void setAgeBracketResults(String ageBracketResults) {
		this.ageBracketResults = ageBracketResults;
	}

	public String getTotalMarriedResults() {
		return totalMarriedResults;
	}

	public void setTotalMarriedResults(String totalMarriedResults) {
		this.totalMarriedResults = totalMarriedResults;
	}

	public String getTotalNotMarriedResults() {
		return totalNotMarriedResults;
	}

	public void setTotalNotMarriedResults(String totalNotMarriedResults) {
		this.totalNotMarriedResults = totalNotMarriedResults;
	}

	public String getEducationResults() {
		return educationResults;
	}

	public void setEducationResults(String educationResults) {
		this.educationResults = educationResults;
	}
}
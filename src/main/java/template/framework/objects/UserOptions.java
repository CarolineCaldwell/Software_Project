package template.framework.objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserOptions {
	 
    	@Size(min=2, max=30)
	    private String locationName;
    	
	    private String income;
	    private String relationshipStatus;
	    private String age;
	    private String communityType;
	    private String schoolImportance;
	    
	    // getters and setters...
		public String getLocationName() {
			return locationName;
		}
		public void setLocationName(String locationName) {
			this.locationName = locationName;
		}
		public String getIncome() {
			return income;
		}
		public void setIncome(String income) {
			this.income = income;
		}
		public String getRelationshipStatus() {
			return relationshipStatus;
		}
		public void setRelationshipStatus(String relationshipStatus) {
			this.relationshipStatus = relationshipStatus;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getCommunityType() {
			return communityType;
		}
		public void setCommunityType(String communityType) {
			this.communityType = communityType;
		}
		public String getSchoolImportance() {
			return schoolImportance;
		}
		public void setSchoolImportance(String schoolImportance) {
			this.schoolImportance = schoolImportance;
		}
		
		public boolean isNotValid()
		{
			//if it isn't a valid address
			if(false)
			{
				return true;
			}
			
			//else return true
			return false;
		}
	 
}

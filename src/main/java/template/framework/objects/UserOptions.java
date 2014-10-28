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
	    private String incomeImportance;
	    private String relationshipStatusImportance;
	    private String ageImportance;
	    private String communityTypeImportance;
	    
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
		public String getIncomeImportance() {
			return incomeImportance;
		}
		public void setIncomeImportance(String incomeImportance) {
			this.incomeImportance = incomeImportance;
		}
		
		
		public boolean isNotValid()
        {
            String name = this.locationName;
            Integer zip = null;
            
            //If NULL then not valid
            if(name == null)
            {
                return true;
            }
            
            //TRY to make an integer out of string
            //If it is a string and is not 5 char it is not valid
            try 
            { 
               zip = Integer.parseInt(name);
               if(name.length() != 5)
               {
                   return true;
               }
               return false;
            } 
            catch(NumberFormatException e) 
            { 
                    //Not a zip code 
            }
            
            //Begin check for city, state format
            for (int i = 0; i < name.length(); i++)
            {
                if(name.charAt(i) == ',' & i > 0 & i < (name.length() - 2))
                {
                    return false;
                }
            }
            return true;            
            //End of Function
        }
		public String getRelationshipStatusImportance() {
			return relationshipStatusImportance;
		}
		public void setRelationshipStatusImportance(
				String relationshipStatusImportance) {
			this.relationshipStatusImportance = relationshipStatusImportance;
		}
		public String getAgeImportance() {
			return ageImportance;
		}
		public void setAgeImportance(String ageImportance) {
			this.ageImportance = ageImportance;
		}
		public String getCommunityTypeImportance() {
			return communityTypeImportance;
		}
		public void setCommunityTypeImportance(String communityTypeImportance) {
			this.communityTypeImportance = communityTypeImportance;
		}
     
	 
}

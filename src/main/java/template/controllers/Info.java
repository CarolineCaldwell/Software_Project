package template.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {
	private String lng;
	private String lat;
	
	public String getLng() {
		return lng;
	}

	public String getLat() {
		return lat;
	}	

}
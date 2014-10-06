package template.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {
	private String lng;
	private String lat;
	private String FIPS;
	
	Info() {
		lat = "";
		lng = "";
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
}
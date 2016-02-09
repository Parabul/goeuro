package com.anarbek.projects.goeuro.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoPosition {

	@JsonProperty("latitude")
	private Double latitude;
	@JsonProperty("longitude")
	private Double longitude;

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return String.format("GeoPosition [latitude=%s, longitude=%s]",
				latitude, longitude);
	}

}

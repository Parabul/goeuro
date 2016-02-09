package com.anarbek.projects.goeuro.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.anarbek.projects.goeuro.utils.Recordable;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Suggest implements Recordable {

	public static final Object[] file_header = { "_id", "name", "type",
			"latitude", "longitude" };

	@JsonProperty("_id")
	private Long id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("type")
	private String type;
	@JsonProperty("geo_position")
	private GeoPosition geoPosition;

	public List<String> getRecord() {
		return new ArrayList<String>(Arrays.asList(new String[] {
				id.toString(), name, type,
				geoPosition.getLatitude().toString(),
				geoPosition.getLongitude().toString() }));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public GeoPosition getGeoPosition() {
		return geoPosition;
	}

	public void setGeoPosition(GeoPosition geoPosition) {
		this.geoPosition = geoPosition;
	}

	@Override
	public String toString() {
		return String.format(
				"Suggest [id=%s, name=%s, type=%s, geoPosition=%s]", id, name,
				type, geoPosition);
	}

}

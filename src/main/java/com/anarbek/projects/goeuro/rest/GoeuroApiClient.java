package com.anarbek.projects.goeuro.rest;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.anarbek.projects.goeuro.entity.Suggest;
import com.anarbek.projects.goeuro.entity.SuggestResponse;

public class GoeuroApiClient {

	private static final String url_pattern = "http://api.goeuro.com/api/v2/position/suggest/en/{0}";

	private RestTemplate restTemplate;

	public GoeuroApiClient() {
		restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());
	}

	List<Suggest> getSuggests(String location) {
		String url = MessageFormat.format(url_pattern, location);
		SuggestResponse response = restTemplate.getForObject(url,
				SuggestResponse.class);
		return response;
	}
}

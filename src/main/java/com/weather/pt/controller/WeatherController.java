package com.weather.pt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.pt.response.DataResponse;

@RestController
@RequestMapping(value = "weather")
public class WeatherController {

	@Autowired
	private RestTemplate rest;
	
	@Autowired
	private ObjectMapper mapper;
	
	private String url = "http://api.weatherstack.com/current?access_key=d98f62b2d1b173bdaf5d0075378d27dc&query=";


	@GetMapping(value = "{cities}")
	public ResponseEntity<List<DataResponse>> getWeather(@PathVariable("cities") String[] cities) throws JsonMappingException, JsonProcessingException {
		
		List<String> responses = new ArrayList<>();
				
		for (String x : cities) {
			responses.add(rest.getForEntity(url + x, String.class).getBody());
		}
		responses.add(rest.getForEntity("http://api.weatherstack.com/current?access_key=d98f62b2d1b173bdaf5d0075378d27dc&query=Braganca, Portugal", String.class).getBody());
		
		List<DataResponse> responsesDatas = new ArrayList<>();
		for (String response : responses) {
			responsesDatas.add(mapper.readValue(response, DataResponse.class));
		}
		
		return ResponseEntity.ok().body(responsesDatas);
	}
	
}

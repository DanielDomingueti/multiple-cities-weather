package com.weather.pt.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.weather.pt.modules.Current;
import com.weather.pt.modules.Location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataResponse {
	
	private Location location;
	private Current current;

}

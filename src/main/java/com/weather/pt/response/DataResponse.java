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
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataResponse {
	
	private Location location;
	private Current current;
	
	@Override
	public String toString() {
		return "Local: " + location.getName() + ", " + location.getCountry() + " - Temperatura atual: " + current.getTemperature() + "\u00B0" + "C -- Horário: " + current.getObservation_time();
	}
	
	

}

package com.reservoir.api.reservoir;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class ReservoirController {

	@Autowired
	private ReservoirService reservoir_service;
	
	@RequestMapping("/reservoirs")
	public List<Reservoir> getReservoirs(){
		return reservoir_service.getReservoirs();
	}
	
	@RequestMapping("/reservoirs/{id}")
	public Reservoir getReservoir(@PathVariable("id") String id){
		return reservoir_service.getReservoir(id);
	}
}

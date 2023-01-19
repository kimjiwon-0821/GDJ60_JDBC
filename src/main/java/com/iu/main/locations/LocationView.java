package com.iu.main.locations;

import java.util.ArrayList;

public class LocationView {
	public void view(String msg) {
		System.out.println(msg);
	}
	public void view(LocationDTO locationDTO) {
		System.out.print(locationDTO.getLocation_id()+"\t");
		System.out.print(locationDTO.getStreet_address()+"\t");
		System.out.print(locationDTO.getPostal_code()+"\t");
		System.out.print(locationDTO.getCity()+"\t");
		System.out.print(locationDTO.getState_province()+"\t");
		System.out.print(locationDTO.getCountry_id()+"\t");
		System.out.println();
	}
	
	public void view(ArrayList<LocationDTO> ar) {
		for(LocationDTO locationDTO : ar) {
			this.view(locationDTO);
		}
		
	}
}

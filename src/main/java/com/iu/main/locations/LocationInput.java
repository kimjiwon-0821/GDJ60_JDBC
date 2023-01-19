package com.iu.main.locations;

import java.util.Scanner;

import com.iu.main.departments.DepartmentDTO;

public class LocationInput {
	private Scanner sc ;
	public LocationInput(){
		sc = new Scanner(System.in);
		
	}
	
	public LocationDTO setData() {
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("거리주소 입력 : ");
		locationDTO.setStreet_address(sc.next());
		System.out.println("지역번호 입력 : ");
		locationDTO.setPostal_code(sc.next());
		System.out.println("도시이름 입력 : ");
		locationDTO.setCity(sc.next());
		System.out.println("state_province 입력 : ");
		locationDTO.setState_province(sc.next());
		System.out.println("나라이름 입력 : ");
		locationDTO.setCountry_id(sc.next());
		return locationDTO;
	}
	
	public LocationDTO deleteData() {
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("삭제할 지역 번호 : ");
		locationDTO.setLocation_id(sc.nextInt());
		return locationDTO;
	}

}

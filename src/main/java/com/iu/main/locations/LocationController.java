package com.iu.main.locations;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {
	private Scanner sc;
	private LocationDAO locationDAO;
	private LocationView locationView;
	private LocationInput locationInput;
	public LocationController() {
		this.sc = new Scanner(System.in);
		this.locationDAO = new LocationDAO();
		this.locationView = new LocationView();
		this.locationInput = new LocationInput();
	}
	public void start() throws Exception {
		boolean check = true;
		LocationDTO locationDTO=null;
		ArrayList<LocationDTO> ar=null;
		while(check) {
			System.out.println("1. 지역 리스트");
			System.out.println("2. 지역 상세정보");
			System.out.println("3. 주소   검색");
			System.out.println("4. 주소   추가");
			System.out.println("5. 주소   삭제");
			System.out.println("6. 종     료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1 : 
				ar = locationDAO.getList();
				locationView.view(ar);
				break;
			case 2:
				System.out.println("검색할 지역 : ");
				select= sc.nextInt();
				locationDTO=locationDAO.getDetail(select);
				if(locationDTO != null) {
					locationView.view(locationDTO);
				}else {
					locationView.view("data가 없다");
				}
				break;
			case 3:
				System.out.println("검색할 주소 입력 : ");
				String add = sc.next();
				ar =locationDAO.getFind(add);
				locationView.view(ar);
				break;
			case 4:
				
				locationDTO=locationInput.setData();
				select = locationDAO.setData(locationDTO);
				if(select>0)
					locationView.view("추가 성공");
				else
					locationView.view("추가 실패");
				break;
			case 5:
				//locationDTO=locationInput.deleteData();
				//select = locationDAO.deletData(locationDTO);
				break;
				
			default:
				check = false;
				break;
			}
		}
		
	}

}

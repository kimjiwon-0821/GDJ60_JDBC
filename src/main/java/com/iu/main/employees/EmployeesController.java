package com.iu.main.employees;

import java.util.Scanner;

public class EmployeesController {
	//출력 안해도 dto에 다 선언해 줘야함
	//1. 사원정보리스트 - 신입사원순으로 출력 ( 맨위에 가장 최근에 입사한 사원) -> 사원번호, 성, 이름, job_id, 부서번호 출력\
	//2. 개별 사원 정보 - 사원한명의 모든 정보 출력(사원번호로 검색)
	//3. 사원검색 - 사원이름으로 검색(lst_name으로 검색)
	private Scanner sc;
	private EmployeesDAO employeesDAO;
	private EmployeesView employeesView;
	public EmployeesController() {
		this.employeesDAO = new EmployeesDAO();
		this.employeesView = new EmployeesView();
		sc = new Scanner(System.in);
	}
	public void start() throws Exception {
		boolean check = true;
		while(check) {
			System.out.println("1. 사원정보리스트");
			System.out.println("2. 개별사원 정보");
			System.out.println("3. 사원   검색");
			System.out.println("4. 종     료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				employeesView.view(employeesDAO.getList());
				break;
			case 2:
				System.out.println("사원번호 입력 : ");
				select = sc.nextInt();
				if(employeesDAO.getDetail(select)!=null)
					employeesView.view(employeesDAO.getDetail(select));
				else
					employeesView.view("data가 없습니다.");
				break;
			case 3:
				System.out.println("사원이릅 입력 : ");
				String name = sc.next();
				if(employeesDAO.getFind(name)!=null)
					employeesView.view( employeesDAO.getFind(name));
				else
					employeesView.view("data가 없습니다.");
				
				break;
			default :
				System.out.println("프로그램을 종료합니다.");
				check = false;
				break;
				
			}
			
		}
		
	}
	
	

}

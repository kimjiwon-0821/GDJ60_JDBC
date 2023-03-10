package com.iu.main.departments;

import java.util.ArrayList;

import com.iu.main.employees.EmployeesDTO;

public class DepartmentDTO{
	//모든 멤버변수의 접근지정자는 private
	//멤버변수의 데이터타입과 변수명은
	//Table의 컬럼과 데이터타입과 컬럼명과 일치 시킴
	//Getter/Setter 생성
	//생성자는 여러개 있어도 상관 x
	//꼭 기본생성자는 있어야 함
	private Integer department_id;
	private String department_name;
	private Integer manager_id;
	private Integer location_id;
	
	private ArrayList<EmployeesDTO> employeesDTOs; // 부서는 사원을 가지고 있다. -- 양방향
	//부서는 사원과 1:N 관계이기 때문에 사원이 몇명이 오는지 모름 --arraylist
	
	public Integer getDepartment_id() {
		return department_id;
	}
	public ArrayList<EmployeesDTO> getEmployeesDTOs() {
		return employeesDTOs;
	}
	public void setEmployeesDTOs(ArrayList<EmployeesDTO> employeesDTOs) {
		this.employeesDTOs = employeesDTOs;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public Integer getManager_id() {
		return manager_id;
	}
	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}
	public Integer getLocation_id() {
		return location_id;
	}
	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}
	
}

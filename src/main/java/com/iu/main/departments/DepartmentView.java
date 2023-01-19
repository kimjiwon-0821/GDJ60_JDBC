package com.iu.main.departments;

import java.util.ArrayList;

public class DepartmentView {
	//view
	public void view(String msg) {
		System.out.println(msg);
	}
	
	public void view(DepartmentDTO departmentDTO) {
		System.out.println(departmentDTO.getDepartment_name());
		System.out.println(departmentDTO.getDepartment_id());
		
	}
	public void view(ArrayList<DepartmentDTO> ar) {
		for(DepartmentDTO departmentDTO:ar) {
			this.view(departmentDTO);
		}
	}

}

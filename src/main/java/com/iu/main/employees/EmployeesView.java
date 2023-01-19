package com.iu.main.employees;

import java.util.ArrayList;

public class EmployeesView {
	public void view(String msg) {
		System.out.println(msg);
		
	}
	
	public void view(EmployeesDTO employeesDTO) {
		System.out.print(employeesDTO.getEMPLOYEE_ID()+"\t");
		System.out.print(employeesDTO.getFIRST_NAME()+"\t");
		System.out.print(employeesDTO.getLAST_NAME()+"\t");
		System.out.print(employeesDTO.getEMAIL()+"\t");
		System.out.print(employeesDTO.getPHONE_NUMBER()+"\t");
		System.out.print(employeesDTO.getHIRE_DATE()+"\t");
		System.out.print(employeesDTO.getJOB_ID()+"\t");
		System.out.print(employeesDTO.getSALARY()+"\t");
		System.out.print(employeesDTO.getCOMMISSION_PCT()+"\t");
		System.out.print(employeesDTO.getMANAGER_ID()+"\t");
		System.out.print(employeesDTO.getDEPARTMENT_ID()+"\t");
		System.out.println();
	}
	
	public void view(ArrayList<EmployeesDTO> ar) {
		for(EmployeesDTO employeesDTO : ar) {
			this.view(employeesDTO);
		}
	}

}

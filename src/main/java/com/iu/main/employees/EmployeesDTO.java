package com.iu.main.employees;

import java.sql.Date;

import oracle.sql.DATE;

public class EmployeesDTO {
	private Integer EMPLOYEE_ID; // instance field를 선언할 때 data type이 int 일때 이왕잉면 reference type이 null이 왔을때 방어할 수 있다.
	private String FIRST_NAME; // 대소문자 구분을 하지 않기 때문에 소문자로 작성해도 상관 없다.
	private String LAST_NAME;
	private String EMAIL;
	private String PHONE_NUMBER;
	private Date HIRE_DATE;
	private String JOB_ID;
	private Integer SALARY;
	private Double COMMISSION_PCT;
	private Integer MANAGER_ID;
	private Integer DEPARTMENT_ID;
	
	public Integer getEMPLOYEE_ID() {
		return EMPLOYEE_ID;
	}
	public void setEMPLOYEE_ID(Integer eMPLOYEE_ID) {
		EMPLOYEE_ID = eMPLOYEE_ID;
	}
	public String getFIRST_NAME() {
		return FIRST_NAME;
	}
	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}
	public String getLAST_NAME() {
		return LAST_NAME;
	}
	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getPHONE_NUMBER() {
		return PHONE_NUMBER;
	}
	public void setPHONE_NUMBER(String pHONE_NUMBER) {
		PHONE_NUMBER = pHONE_NUMBER;
	}
	public Date getHIRE_DATE() {
		return HIRE_DATE;
	}
	public void setHIRE_DATE(Date date) {
		HIRE_DATE = date;
	}
	public String getJOB_ID() {
		return JOB_ID;
	}
	public void setJOB_ID(String jOB_ID) {
		JOB_ID = jOB_ID;
	}
	public Integer getSALARY() {
		return SALARY;
	}
	public void setSALARY(Integer sALARY) {
		SALARY = sALARY;
	}
	public Double getCOMMISSION_PCT() {
		return COMMISSION_PCT;
	}
	public void setCOMMISSION_PCT(Double cOMMISSION_PCT) {
		COMMISSION_PCT = cOMMISSION_PCT;
	}
	public Integer getMANAGER_ID() {
		return MANAGER_ID;
	}
	public void setMANAGER_ID(Integer mANAGER_ID) {
		MANAGER_ID = mANAGER_ID;
	}
	public int getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}
	public void setDEPARTMENT_ID(Integer dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}
}

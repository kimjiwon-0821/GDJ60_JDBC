package com.iu.main.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.iu.main.util.DBConnection;

public class EmployeesDAO {
	//월급의 평균
	public HashMap<String, Integer> getAvg() throws Exception{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT AVG(SALARY)*12+100 AS A, SUM(SALARY) FROM EMPLOYEES";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		
		//1. List, Array
		//2. DTO(class)
		//3. map(key,value)
		
		map.put("avg", rs.getInt("A"));
		map.put("sum", rs.getInt(2));
		
		DBConnection.disConnect(rs, st, connection);
		return map;
	}
	
	
	//method 1 : query 1
	//사원 추가
	
	//사원 검색
	public EmployeesDTO getFind(String search) throws Exception { // locationDAO에 다른 방법 있음
		EmployeesDTO employeesDTO = null;
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME= ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, search);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			employeesDTO = new EmployeesDTO();
			employeesDTO.setEMPLOYEE_ID(rs.getInt("EMPLOYEE_ID"));
			employeesDTO.setFIRST_NAME(rs.getString("FIRST_NAME"));
			employeesDTO.setLAST_NAME(rs.getNString("LAST_NAME"));
			employeesDTO.setEMAIL(rs.getString("EMAIL"));
			employeesDTO.setPHONE_NUMBER(rs.getString("PHONE_NUMBER"));
			employeesDTO.setHIRE_DATE(rs.getString("HIRE_DATE"));
			employeesDTO.setJOB_ID(rs.getString("JOB_ID"));
			employeesDTO.setSALARY(rs.getInt("SALARY"));
			employeesDTO.setCOMMISSION_PCT(rs.getDouble("COMMISSION_PCT"));
			employeesDTO.setMANAGER_ID(rs.getInt("MANAGER_ID"));
			employeesDTO.setDEPARTMENT_ID(rs.getInt("DEPARTMENT_ID"));
		}
		DBConnection.disConnect(rs, st, connection);
		return employeesDTO;
	}
	
	//개별 사원
	public EmployeesDTO getDetail(int select) throws Exception {
		EmployeesDTO employeesDTO = null;
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, select);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			employeesDTO = new EmployeesDTO();
			employeesDTO.setEMPLOYEE_ID(rs.getInt("EMPLOYEE_ID"));
			employeesDTO.setFIRST_NAME(rs.getString("FIRST_NAME"));
			employeesDTO.setLAST_NAME(rs.getNString("LAST_NAME"));
			employeesDTO.setEMAIL(rs.getString("EMAIL"));
			employeesDTO.setPHONE_NUMBER(rs.getString("PHONE_NUMBER"));
			employeesDTO.setHIRE_DATE(rs.getString("HIRE_DATE"));
			employeesDTO.setJOB_ID(rs.getString("JOB_ID"));
			employeesDTO.setSALARY(rs.getInt("SALARY"));
			employeesDTO.setCOMMISSION_PCT(rs.getDouble("COMMISSION_PCT"));
			employeesDTO.setMANAGER_ID(rs.getInt("MANAGER_ID"));
			employeesDTO.setDEPARTMENT_ID(rs.getInt("DEPARTMENT_ID"));
		}
		DBConnection.disConnect(rs, st, connection);
		return employeesDTO;
		
	}
	
	//사원 리스트
	public ArrayList<EmployeesDTO> getList() throws Exception {
		ArrayList<EmployeesDTO> ar = new ArrayList<EmployeesDTO>();
		Connection connection = DBConnection.getConnection();
		//2. Query문 작성
		String sql = "SELECT EMPLOYEE_ID ,FIRST_NAME , LAST_NAME , JOB_ID , DEPARTMENT_ID FROM EMPLOYEES ORDER BY HIRE_DATE DESC";
		//3 Query 미리 전송
		PreparedStatement st = connection.prepareStatement(sql);
		//4. ? 값 처리
		//5.최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		while(rs.next()) { // 한줄 읽어오기
			EmployeesDTO employeesDTO = new EmployeesDTO();
			employeesDTO.setEMPLOYEE_ID(rs.getInt("EMPLOYEE_ID"));
			employeesDTO.setFIRST_NAME(rs.getString("FIRST_NAME"));
			employeesDTO.setLAST_NAME(rs.getNString("LAST_NAME"));
			employeesDTO.setJOB_ID(rs.getString("JOB_ID"));
			employeesDTO.setDEPARTMENT_ID(rs.getInt("DEPARTMENT_ID"));
			ar.add(employeesDTO);
		}
		//6. 연결 해제
		DBConnection.disConnect(rs, st, connection);
		return ar;
	}

}

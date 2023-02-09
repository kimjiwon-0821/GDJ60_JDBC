package com.iu.main.departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.employees.EmployeesDTO;
import com.iu.main.util.DBConnection;

public class DepartmentDAO {//방법1
	//
	
	public void getInfos() throws Exception {
		System.out.println("모르겠당 집가고 싶당 강사님 집보내주세용");
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT E.FIRAT_NAME, D.DEPARTMENT_NAME "
				+ "FROM EMPLOYEES E INNER JOIN DEPARTMENT D "
				+ "USING(DEPARTMENT_ID) WHERE DEPARTMENT_ID =30";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setEmployeesDTOs(new ArrayList<EmployeesDTO>());
		while(rs.next()) {
			if(departmentDTO.getDepartment_name()==null) {
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			}
			EmployeesDTO employeesDTO = new EmployeesDTO();
			employeesDTO.setFIRST_NAME(rs.getString("FIRST_NAME"));
			departmentDTO.getEmployeesDTOs().add(employeesDTO);
		}
	}
	
	//JOIN
	public DepartmentDTO getInfo() throws Exception{
		DepartmentDTO departmentDTO = null;
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT E.FIRST_NAME D.DEPARTMENT_NAME "
				+ "FROM EMPLOYEES E INNER JOIN DEPARTMENTS D "
				+ "USTIND(DEPARTMENT_ID) WHERE E.EMPLOYEE_ID=100";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setEmployeesDTOs(new ArrayList<EmployeesDTO>());
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.getEmployeesDTOs().get(0).setFIRST_NAME(rs.getString("DEPARTMENT_NAME"));
			EmployeesDTO employeesDTO = new EmployeesDTO();
			employeesDTO.setFIRST_NAME(rs.getString("FIRST_NAME"));
			departmentDTO.getEmployeesDTOs().add(employeesDTO);
		}
		return departmentDTO;
	}
	
	
	public int updateDate(DepartmentDTO departmentDTO) throws Exception{
		Connection connection = DBConnection.getConnection();
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME = ?, "
				+ "MANAGER_ID=?, LOCATION_ID=? WHERE DEPARTMENT_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, departmentDTO.getDepartment_name());
		st.setInt(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		st.setInt(4, departmentDTO.getDepartment_id());
		int result = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		return result;
	}
	
	
	//delete
	public int deleteData (DepartmentDTO departmentDTO) throws Exception{
		Connection connection = DBConnection.getConnection();
		String sql = "DELETE DEPARTMENTS WHERE  DEPARTMENT_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, departmentDTO.getDepartment_id());
		int result = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		return result;
	}
	
	
	//insert
	public int setData(DepartmentDTO departmentDTO) throws Exception{
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO DEPARTMENTS(DEPARTMENT_ID, DEPARTMENT_NAME, "
				+ "MANAGER_ID, LOCATION_ID) "
				+ "VALUES(DEPARTMENTS_SEQ.NEXTVAL, ? , ? , ? )";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, departmentDTO.getDepartment_name());
		st.setInt(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		//select문이 아니기때문에 숫자로 받음(insert,delete,update-executeUpdate)
		int result = st.executeUpdate(); //0이면 실패, 1이면 성공
		DBConnection.disConnect(st, connection);
		return result;	
	}
	
	
	public DepartmentDTO getDetail(int department_id) throws Exception{
		DepartmentDTO departmentDTO=null;
		Connection connection = DBConnection.getConnection();
		String  sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);//?의 값이 없는 상태로 Query문을 미리 보냄
		st.setInt(1, department_id); // oracle에서는 index가 1부터 시작
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			
		}//else {
//			System.out.println("data가 없다");
//		}
		DBConnection.disConnect(rs, st, connection);
		return departmentDTO;
	}
	
	public ArrayList<DepartmentDTO> getList() throws Exception{
		ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
		//1,2번 삭제
		//DBConnection con = new DBConnection();
		Connection connection = DBConnection.getConnection(); // -> static을 부여하였기 때문에 객체를 생성하지 않고 쓸수 있음 -> 클래스명.메소드명
		//3. Query문 생성
		String sql = "SELECT * FROM DEPARTMENTS";
		
		//4. Query문 미리 전송
		PreparedStatement st = connection.prepareStatement(sql); // PreparedStatement : ?를 변수로 인식하여 SQLInjection을 막아준다.
		
		//5. ? 세팅
		
		//6. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			ar.add(departmentDTO);
		}
		
		//7. 연결 해제
		DBConnection.disConnect(rs, st, connection);
		return ar;
		
	}

}

package com.iu.main;

import com.iu.main.departments.DepartmentController;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.departments.DepartmentDTO;
import com.iu.main.employees.EmployeesController;
import com.iu.main.employees.EmployeesDAO;
import com.iu.main.locations.LocationController;
import com.iu.main.locations.LocationDAO;
import com.iu.main.util.DBConnection;

public class JDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start");
		
//		DBConnection con = new DBConnection();
		//DepartmentDAO dao1 = new DepartmentDAO();
		//LocationDAO dao2 = new LocationDAO();
		//EmployeesDAO dao3 = new EmployeesDAO();
		//DepartmentController dc = new DepartmentController();
		//LocationController lc = new LocationController();
		//EmployeesController ec = new EmployeesController();
		FrontController fc = new FrontController();
		try {
			fc.start();
			//lc.start();
			//dc.start();
			//ec.start();
			//DepartmentDTO departmentDTO = new DepartmentDTO();
//			departmentDTO.setDepartment_id(280);
//			int result = dao1.deleteData(departmentDTO);
//			if(result>0) {
//				System.out.println("성공");
//			}
//			else {
//				System.out.println("실패");
			//}
			//dao2.getList();
			//dao2.getDetail(20);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("finish");

	}

}

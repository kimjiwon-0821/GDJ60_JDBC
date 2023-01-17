package com.iu.main;

import com.iu.main.util.DBConnection;

public class JDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start");
		
		DBConnection con = new DBConnection();
		try {
			con.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("finish");

	}

}

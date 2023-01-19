package com.iu.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() throws Exception {
	//1. 접속 정보 준비
		//1. id
		String username = "hr";
		//2. pw
		String password = "hr";
		//3. url
		String url="jdbc:oracle:thin:@ localhost:1521/XEPDB1";
		//-> id가 sid이면 String url="jdbc:oracle:thin:@ ip:port:SID";
//		//4. driver
		String deiver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(deiver); //->현재는 생략해도 자동으로 생성
		
	//2. DB 접속 실행
		Connection connection = DriverManager.getConnection(url, username, password);
	//3,4,5,6 삭제
		return connection;
	//7번 삭제
		//disConnect 메소드 생성 및 호출
	}
	//close를 위한 class
	public static void disConnect(ResultSet rs , PreparedStatement st , Connection connection) throws Exception {
		rs.close();
		st.close();
		connection.close();
		
	}
	public static void disConnect(PreparedStatement st, Connection connection)throws Exception{
		st.close();
		connection.close();
	}

}

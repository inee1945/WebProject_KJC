package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;

public class JDBConnect {
	public Connection con ;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public JDBConnect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "musthave";
			String pwd = "1234";
			con = DriverManager.getConnection(url,id,pwd);
			System.out.println("오라클 연결성공(기본생성자)");
		}catch(Exception e) {
			System.out.println("oracle예외발생");
			e.printStackTrace();
		}
	}
	public JDBConnect(String driver, String url, String id,String pwd){
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,id,pwd);
			System.out.println("디비연결 성공(인수생성자1)");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public JDBConnect(ServletContext application) {
		try {
			String driver = application.getInitParameter("OracleDriver");
			Class.forName(driver);
			String url = application.getInitParameter("OracleURL");
			String id = application.getInitParameter("OracleId");
			String pwd = application.getInitParameter("OraclePwd");
			con=DriverManager.getConnection(url,id,pwd);
			System.out.println("디비연결 성공(인수생성자2)");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(psmt!=null) psmt.close();
			if(con!=null) con.close();
			System.out.println("JDBC자원해제");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
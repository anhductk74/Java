package DBManage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ConnectDB {
	Connection conn;
	Statement stmt;
	PreparedStatement psmt;
	public void connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String Url = "jdbc:sqlserver://DESKTOP-JH8LDLJ\\SQLEXPRESS:1433;databaseName=Student;user=sa;password=123456789";
			conn =  DriverManager.getConnection(Url);
			System.out.println("connect successfully");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public Connection connectSQL() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String Url = "jdbc:sqlserver://DESKTOP-JH8LDLJ\\SQLEXPRESS:1433;databaseName=Student;user=sa;password=123456789";
			conn =  DriverManager.getConnection(Url);
			System.out.println("connect successfully");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	
	public int executeDB(String sql) {
		int record=0;
		try {
			connect();
			stmt = conn.createStatement();
			record = stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return record;
	}
	
	public int executeDBprepared(String sql) {
		int record=0;
		try {
			connect();
			psmt = conn.prepareStatement(sql);
			record = stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return record;
	}
}

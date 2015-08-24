package solution.egen.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {

	private final static String DB_URL = "jdbc:mysql://localhost:3306/restaurant_egen";
	private final static String DB_USER = "root";
	private final static String DB_PASSWORD = "Janhavi-02";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
		} catch (ClassNotFoundException e) {
			System.err.println("error loading driver. " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static Connection connect() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			System.out.println("Connection successful");
		} catch (SQLException e) {
			System.err.println("Connection Error: " + e.getMessage());
			e.printStackTrace();
		}
		return con;
	}
	public static void closeResource(PreparedStatement ps ,ResultSet rs , Connection con){
		try {
			if (ps != null)
			{
				
					ps.close();
				}
			if (rs != null)
			{
				
					rs.close();
				}
			if (con != null)
			{
				
					con.close();
				}
			rs.close();
			con.close();
			}
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		
	}
	
	public static void main(String[] args){
		
		
		
		DBConnector.connect();
	}
	
		}


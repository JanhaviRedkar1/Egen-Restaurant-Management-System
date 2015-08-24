package solution.egen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import solution.egen.exception.AppException;
import solution.egen.model.auth;
import solution.egen.utilities.DBConnector;

public class LoginDAO {
public boolean authenticated(auth au) throws AppException {
		
		
		auth af=new auth();
		Connection con = DBConnector.connect();
		PreparedStatement ps= null;
		ResultSet rs = null;
		boolean a;
		try {
			ps= con.prepareStatement("SELECT * FROM restaurant_egen.login ");	
			rs=ps.executeQuery();
			while(rs.next())
			{
				
				af.setUsername(rs.getString("username"));
				af.setPassword(rs.getString("password"));
				
				
			}
		
			a = (au.getUsername().equals(af.getUsername())) && (au.getPassword().equals(af.getPassword()));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("Error in Fetching records from Database" , e.getCause());
		}
		finally{
			DBConnector.closeResource(ps, rs, con);
				}
		return a;
	}


}

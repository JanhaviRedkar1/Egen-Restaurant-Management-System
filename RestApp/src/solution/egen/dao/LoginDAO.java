package solution.egen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import solution.egen.exception.AppException;

import solution.egen.utilities.DBConnector;

public class LoginDAO {
public boolean authenticated(String user , String pwd) throws AppException {
		
		
		
		Connection con = DBConnector.connect();
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			ps= con.prepareStatement("SELECT * FROM restaurant_egen.login where username =? && password= ?");
			ps.setString(1, user);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			if(rs != null){
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("Error in Fetching records from Database" , e.getCause());
		}
		finally{
			DBConnector.closeResource(ps, rs, con);
				}
		
	}


}

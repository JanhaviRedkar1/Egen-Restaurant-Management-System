



package solution.egen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import solution.egen.exception.AppException;

import solution.egen.model.tables;
import solution.egen.utilities.DBConnector;

public class TablesDAO {
	
	
	public List<tables> getall() throws AppException {
		List<tables> tableList = new ArrayList<tables>();
		Connection con = DBConnector.connect();
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			ps= con.prepareStatement("SELECT * FROM restaurant_egen.table_setting");
			rs=ps.executeQuery();
			while(rs.next()){
				
				tables t = new tables();
				t.setTable_no(rs.getInt("Table_id"));
				t.setCapacity(rs.getInt("Capacity"));
				t.setStatus(rs.getInt("Status"));
				tableList.add(t);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("Error in Fetching records from Database" , e.getCause());
		}
		finally{
			DBConnector.closeResource(ps, rs, con);
				}
		return tableList;
	}
	
	
	
	
	
	public tables getPerson(int capacity) throws AppException {
		
		
		tables t =new tables();
		Connection con = DBConnector.connect();
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			ps= con.prepareStatement("SELECT * FROM restaurant_egen.table_setting where status = 0 && capacity= ?");
			ps.setInt(1, capacity);
			rs=ps.executeQuery();
			if(rs.next()){
				
				t.setTable_no(rs.getInt("Table_No"));
				
				
				
				
			}
			else
			{
				throw new AppException ("No Tables Available");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("Error in Fetching records from Database" , e.getCause());
		}
		finally{
			DBConnector.closeResource(ps, rs, con);
				}
		return t;
	}
	

}

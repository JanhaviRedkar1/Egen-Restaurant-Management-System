package solution.egen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import solution.egen.exception.AppException;
import solution.egen.model.customers;

import solution.egen.utilities.DBConnector;

public class CustomerDAO {
	public List<customers> getall() throws AppException {
		List<customers> custList = new ArrayList<customers>();
		Connection con = DBConnector.connect();
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			ps= con.prepareStatement("SELECT * FROM restaurant_egen.custemers");
			rs=ps.executeQuery();
			while(rs.next()){
				customers cust = new customers();
				cust.setCustomer_id(rs.getInt("customer_id"));
				cust.setCustomer_name(rs.getString("customer_name"));
				cust.setPhone_no(rs.getString("Phone_no"));
				cust.setEmail_id(rs.getString("Email_id"));
				custList.add(cust);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("Error in Fetching records from Database" , e.getCause());
		}
		finally{
			DBConnector.closeResource(ps, rs, con);
				}
		return custList;
	}
	public customers addCustomers(customers cust) throws AppException {
		
		Connection con = DBConnector.connect();
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			ps= con.prepareStatement("INSERT INTO `restaurant_egen`.`custemers` ( `customer_name`, `Phone_no`, `Email_id`) VALUES (? ,?,?)" , PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, cust.getCustomer_name());
			ps.setString(2, cust.getPhone_no());
			ps.setString(3, cust.getEmail_id());
			ps.executeUpdate();
			
			rs=ps.getGeneratedKeys();
			if(rs.next())
			{
				cust.setCustomer_id(rs.getInt(1));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("Error in Fetching records from Database" , e.getCause());
		}
		finally{
			DBConnector.closeResource(ps, rs, con);
				}
		return cust;
	}
	
	
	public customers getPerson(int customer_id) throws AppException {
		customers cust = new customers();
		Connection con = DBConnector.connect();
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			ps= con.prepareStatement("SELECT * FROM restaurant_egen.custemers where customer_id =?");
			ps.setInt(1, customer_id);
			rs=ps.executeQuery();
			if(rs.next()){
				
				cust.setCustomer_id(rs.getInt("customer_id"));
				cust.setCustomer_name(rs.getString("customer_name"));
				cust.setPhone_no(rs.getString("Phone_no"));
				cust.setEmail_id(rs.getString("Email_id"));
				
			}
			else
			{
				throw new AppException ("Employee with ID" + customer_id + "does not exist in the system");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("Error in Fetching records from Database" , e.getCause());
		}
		finally{
			DBConnector.closeResource(ps, rs, con);
				}
		return cust;
	}
	

}

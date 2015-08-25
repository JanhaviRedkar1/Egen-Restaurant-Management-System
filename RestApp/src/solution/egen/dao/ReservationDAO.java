


package solution.egen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import solution.egen.exception.AppException;

import solution.egen.model.reservations;

import solution.egen.utilities.DBConnector;

public class ReservationDAO {
	
	
	public List<reservations> getall() throws AppException {
		List<reservations> reserveList = new ArrayList<reservations>();
		Connection con = DBConnector.connect();
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			ps= con.prepareStatement("SELECT * FROM restaurant_egen.reservations");
			rs=ps.executeQuery();
			while(rs.next()){
				reservations reserve = new reservations();
				reserve.setReservation_id(rs.getInt("reservation_id"));
				
				reserve.setReservation_name(rs.getString("reservation_name"));
				reserve.setNo_of_people(rs.getInt("no_of_people"));
				reserve.setDate(rs.getDate("date"));
				reserve.setTime(rs.getString("time"));;
				reserve.setEmail_id(rs.getString("email_id"));
				reserve.setPhone_no(rs.getString("phone_no"));
				reserveList.add(reserve);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("Error in Fetching records from Database" , e.getCause());
		}
		finally{
			DBConnector.closeResource(ps, rs, con);
				}
		return reserveList;
	}
	
	
	public reservations addReservations(reservations reserve) throws AppException {
		
		Connection con = DBConnector.connect();
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			ps= con.prepareStatement("INSERT INTO `restaurant_egen`.`reservations` ( `reservation_name`, `no_of_people`, `date`, `time`, `email_id`, `phone_no`) VALUES  (? ,?,?,?,?,?)" , PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, reserve.getReservation_name());
			
			ps.setInt(2, reserve.getNo_of_people());
			ps.setDate(3, reserve.getDate());
			ps.setString(4, reserve.getTime());
			ps.setString(5, reserve.getEmail_id());
			ps.setString(6, reserve.getPhone_no());
			ps.executeUpdate();
			
			rs=ps.getGeneratedKeys();
			if(rs.next())
			{
				reserve.setReservation_id(rs.getInt(1));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("Error in Fetching records from Database" , e.getCause());
		}
		finally{
			DBConnector.closeResource(ps, rs, con);
				}
		return reserve;
	}
	
	
	
	public reservations getPerson(String reservation_id) throws AppException {
		
		reservations reserve = new reservations();
		
		Connection con = DBConnector.connect();
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			ps= con.prepareStatement("SELECT * FROM restaurant_egen.reservations where reservation_id =?");
			ps.setString(1, reservation_id);
			rs=ps.executeQuery();
			if(rs.next()){
				
				
				reserve.setReservation_id(rs.getInt("reservation_id"));
				reserve.setReservation_name(rs.getString("reservation_name"));
				reserve.setNo_of_people(rs.getInt("no_of_people"));
				reserve.setDate(rs.getDate("date"));
				reserve.setTime(rs.getString("time"));;
				reserve.setEmail_id(rs.getString("email_id"));
				reserve.setPhone_no(rs.getString("phone_no"));
			}
			else
			{
				throw new AppException ("Employee with ID" + reservation_id + "does not exist in the system");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("Error in Fetching records from Database" , e.getCause());
		}
		finally{
			DBConnector.closeResource(ps, rs, con);
				}
		return reserve;
	}
	
public reservations updateReservations(reservations reserve) throws AppException {
		
		
		Connection con = DBConnector.connect();
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			ps= con.prepareStatement("UPDATE restaurant_egen.reservations SET no_of_people=?, date=? ,time=? WHERE reservation_id=?");
			ps.setInt(1, reserve.getNo_of_people());
			ps.setDate(2, reserve.getDate());
			ps.setString(3, reserve.getTime());
			ps.setInt(4, reserve.getReservation_id());
			ps.executeUpdate();
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("Error in Fetching records from Database" , e.getCause());
		}
		finally{
			DBConnector.closeResource(ps, rs, con);
				}
		return reserve;
	}
	
/*public reservations updateTableInfo(int table_no, String reservation_id) throws AppException {
	
	reservations reserve=new reservations();
	Connection con = DBConnector.connect();
	PreparedStatement ps= null;
	ResultSet rs = null;
	try {
		ps= con.prepareStatement("UPDATE restaurant_egen.reservations SET table_no=? WHERE reservation_id=?");
		ps.setInt(1, table_no);
		ps.setString(2, reservation_id);
		ps.executeUpdate();
		
		
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new AppException("Error in Fetching records from Database" , e.getCause());
	}
	finally{
		DBConnector.closeResource(ps, rs, con);
			}
	return reserve;
}

*/


public reservations deleteReservations(String reservation_id) throws AppException {
	
	reservations reserve= new reservations();
	Connection con = DBConnector.connect();
	PreparedStatement ps= null;
	ResultSet rs = null;
	try {
		System.out.println("reservation_id" +reservation_id );
		int res123= Integer.parseInt(reservation_id);
		ps= con.prepareStatement("DELETE from restaurant_egen.reservations WHERE reservation_id= ?");

		ps.setInt(1, res123);
		ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		throw new AppException("Error in Fetching records from Database" , e.getCause());
	}
	finally{
		DBConnector.closeResource(ps, rs, con);
			}
	return reserve;
}
}

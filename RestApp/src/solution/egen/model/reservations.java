package solution.egen.model;

public class reservations {

	private int reservation_id;
	private String reservation_name;
	private String table_no;
	private int no_of_people;
	private java.sql.Date date;
	private String time;
	private String email_id;
	private String phone_no;
		
	
	
	public String getReservation_name() {
		return reservation_name;
	}
	public void setReservation_name(String reservation_name) {
		this.reservation_name = reservation_name;
	}
	public String getTable_no() {
		return table_no;
	}
	public void setTable_no(String table_no) {
		this.table_no = table_no;
	}
	public int getNo_of_people() {
		return no_of_people;
	}
	public void setNo_of_people(int no_of_people) {
		this.no_of_people = no_of_people;
	}
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public int getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}
	
}

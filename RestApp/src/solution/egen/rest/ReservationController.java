


package solution.egen.rest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import solution.egen.dao.ReservationDAO;
import solution.egen.exception.AppException;
import solution.egen.model.reservations;

@Path("/reservations")
public class ReservationController {
	@GET 
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getCustomer(@PathParam("id") String reservation_id)
	{
		AppResponse resp=new AppResponse();
		
		try {
			ReservationDAO doa= new ReservationDAO();
			reservations  reserve  = null;
			reserve = doa.getPerson(reservation_id);
			
			resp.setPayload(reserve);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
			
		}
		 return resp;
		
	}
	
	@GET 
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getAll()
	{
		AppResponse resp=new AppResponse();
		
		try {
			ReservationDAO doa= new ReservationDAO();
			List<reservations> reserveList  = null;
			reserveList = doa.getall();
			
			resp.setPayload(reserveList);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
			
		}
		 return resp;
		
	}
	
		@POST
		@Path("/add")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public AppResponse addReservations(reservations reserve)
		{
			AppResponse resp=new AppResponse();
			try {
				ReservationDAO doa= new ReservationDAO();
				
				reserve =  doa.addReservations(reserve);
				resp.setMessage("Customer is added");
				resp.setPayload(reserve);
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resp.setStatus(AppResponse.ERROR);
				resp.setMessage(e.getMessage());
				
			}
			 return resp;
			
		}
		
		@PUT
		@Path("/update/{id}")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public AppResponse updateReservations(@PathParam("id") String reservation_id)
		{
			AppResponse resp=new AppResponse();
			try {
				ReservationDAO doa= new ReservationDAO();
				reservations  reserve  = null;
				reserve = doa.updateReservations(reservation_id);
				resp.setMessage("Reservation is updated");
				resp.setPayload(reserve);
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resp.setStatus(AppResponse.ERROR);
				resp.setMessage(e.getMessage());
				
			}
			 return resp;
			
		}
		@DELETE
		@Path("/delete/{id}")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public AppResponse deleteReservations(@PathParam("id") String reservation_id)
		{
			AppResponse resp=new AppResponse();
			try {
				ReservationDAO doa= new ReservationDAO();
				reservations  reserve  = null;
				reserve = doa.deleteReservations(reservation_id);
				resp.setMessage("Reservation is deleted");
				resp.setPayload(reserve);
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resp.setStatus(AppResponse.ERROR);
				resp.setMessage(e.getMessage());
				
			}
			 return resp;
			
		}
}





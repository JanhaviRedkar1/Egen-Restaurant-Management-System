


package solution.egen.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import solution.egen.dao.TablesDAO;
import solution.egen.exception.AppException;

import solution.egen.model.tables;

@Path("/tables")
public class TableController {
	@GET 
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getCustomer(@PathParam("id") int capacity)
	{
		AppResponse resp=new AppResponse();
		
		try {
			TablesDAO doa= new TablesDAO();
			List<tables> tablesList  = null;
			tablesList = doa.getTables(capacity);
			
			
			resp.setPayload(tablesList);
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
			TablesDAO doa= new TablesDAO();
			List<tables> tablesList  = null;
			tablesList = doa.getall();
			
			resp.setPayload(tablesList);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
			
		}
		 return resp;
		
	}
	
	@PUT
	@Path("/updateTableinfo/{id}/{no}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse updateTableInfo(
			@PathParam("id") String reservation_id,
			@PathParam("no") int table_no
			)
	{
		AppResponse resp=new AppResponse();
		try {
			TablesDAO doa= new TablesDAO();
			tables t  = null;
			resp.setPayload(t);
			t = doa.updateTables(reservation_id,table_no);
			resp.setMessage("Reservation is updated"); 
			
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
			
		}
		 return resp;
		
	}
		
}


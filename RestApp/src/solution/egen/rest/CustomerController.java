package solution.egen.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import solution.egen.dao.CustomerDAO;
import solution.egen.exception.AppException;
import solution.egen.model.customers;

@Path("/customers")
public class CustomerController {
	@GET 
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getCustomer(@PathParam("id") int customer_id)
	{
		AppResponse resp=new AppResponse();
		
		try {
			CustomerDAO doa= new CustomerDAO();
			customers cust  = null;
			cust = doa.getPerson(customer_id);
			
			resp.setPayload(cust);
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
			CustomerDAO doa= new CustomerDAO();
			List<customers> custList  = null;
			custList = doa.getall();
			
			resp.setPayload(custList);
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
	public AppResponse addPerson(customers cust) {
		AppResponse resp = new AppResponse();

		try {
			CustomerDAO dao = new CustomerDAO();
			cust = dao.addCustomers(cust);
			resp.setMessage("Customer has been added to the system.");
			resp.setPayload(cust);
		} catch (AppException e) {
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
		}
		return resp;
	}}

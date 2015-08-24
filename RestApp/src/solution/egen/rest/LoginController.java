
package solution.egen.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import solution.egen.dao.CustomerDAO;
import solution.egen.dao.LoginDAO;
import solution.egen.exception.AppException;
import solution.egen.exception.ExceptionResponse;
import solution.egen.model.auth;

@Path("/authentications")
public class LoginController {
	
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ExceptionResponse authenticate(auth au, @Context HttpServletRequest request)
	{
	
		ExceptionResponse eResponse = new ExceptionResponse();
		LoginDAO dao = new LoginDAO();
		
		boolean isAuthenticated;
		try {
		isAuthenticated = dao.authenticated(au);
		
		HttpSession session = request.getSession(true);
		
		session.setAttribute("USER", au);
		
		if(isAuthenticated) {
			eResponse.setMsg("Authentication successful");
			eResponse.setStatus("success");
		}
		
		else {
			eResponse.setMsg("Invalid");
			eResponse.setStatus(ExceptionResponse.ERROR);
		}
			
		
	} catch (AppException e) {
		e.printStackTrace();
		eResponse.setStatus(ExceptionResponse.ERROR);
		eResponse.setMsg(e.getMessage());
	}
	return eResponse;
	}
	
	@GET
	@Path("/isLogin")
	@Produces(MediaType.APPLICATION_JSON)
	public ExceptionResponse isLoggedIn(@Context HttpServletRequest request)
	{
	
		ExceptionResponse eResponse = new ExceptionResponse();
		
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("USER") != null) {
			eResponse.setMsg("User is logged in");
			eResponse.setStatus("success");
		}
			
		else {
			eResponse.setMsg("User is not logged in");
		eResponse.setStatus(ExceptionResponse.ERROR);
		}
	return eResponse;
	}
}
	
	
	
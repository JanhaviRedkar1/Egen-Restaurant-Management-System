
package solution.egen.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import solution.egen.dao.CustomerDAO;
import solution.egen.dao.LoginDAO;
import solution.egen.exception.AppException;
import solution.egen.model.auth;

@Path("/authentication")
public class LoginController {
	
	@POST
	@Path("/login/{user}/{ pwd}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse tryLogin(
			@PathParam("user") String username ,
			@PathParam("pwd") String password) {
		AppResponse resp = new AppResponse();

		try {
			LoginDAO dao = new LoginDAO();
			boolean isAuthenticated = dao.authenticated(username , password);
			if (isAuthenticated)
			{
				resp.setMessage("Login is Successful.");
			}
			else
			resp.setMessage("Login is Invalid");
			
		} catch (AppException e) {
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
		}
		return resp;
	}}

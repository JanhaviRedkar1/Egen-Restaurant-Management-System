package solution.egen.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
@ApplicationPath("/api")
public class RestAppConfig extends ResourceConfig {

	public RestAppConfig(){
		packages("solution.egen.rest");
	}
}

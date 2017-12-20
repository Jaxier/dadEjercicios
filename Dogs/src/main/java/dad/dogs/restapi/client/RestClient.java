package dad.dogs.restapi.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {

	private WebTarget webTarget;
	
	public RestClient(String target) {
		Client client = ClientBuilder.newClient();
		webTarget = client.target(target);
	}
	
	public Response get(String path) {
		return webTarget.path(path).request().accept(MediaType.APPLICATION_JSON).get();		
	}
	
}

package dad.dogs.restapi.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.ws.rs.core.Response;

/**
 * Documentación de la API: https://dog.ceo/dog-api/
 * @author Fran Vargas
 *
 */
public class DogsService {
	
	private RestClient client;
	
	public DogsService() {
		client = new RestClient("https://dog.ceo/api");
	}
	
	public List<String> getBreeds() {
		Response response = client.get("/breeds/list");
		if (response.getStatus() != 200) {
			throw new RuntimeException("Error: código de error HTTP " + response.getStatus());
		}
		BreedsMessage message = response.readEntity(BreedsMessage.class);
		return message.getBreeds();
	}
	
	public URL getRandomImage(String breed) throws MalformedURLException {
		Response response = client.get("/breed/" + breed + "/images/random");
		if (response.getStatus() != 200) {
			throw new RuntimeException("Error: código de error HTTP " + response.getStatus());
		}
		ImageMessage message = response.readEntity(ImageMessage.class);
		if (message.getStatus().equals("error")) {
			throw new RuntimeException(message.getImage());			
		}
		return new URL(message.getImage());
	}
	
	public static void main(String[] args) throws MalformedURLException {
		DogsService servicio = new DogsService();
		System.out.println(servicio.getBreeds());
		System.out.println(servicio.getRandomImage("labrador"));
	}

}

package dad.dogs.restapi.client;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class BreedsMessage {
	private String status;
	private List<String> breeds = new ArrayList<>();

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@JsonGetter("message")
	public List<String> getBreeds() {
		return breeds;
	}

	@JsonSetter("message")
	public void setBreeds(List<String> breeds) {
		this.breeds = breeds;
	}

}

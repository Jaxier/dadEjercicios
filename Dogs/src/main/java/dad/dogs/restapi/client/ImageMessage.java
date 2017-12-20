package dad.dogs.restapi.client;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ImageMessage {
	private String status;
	private Integer code;
	private String image;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@JsonGetter("message")
	public String getImage() {
		return image;
	}

	@JsonSetter("message")
	public void setImage(String image) {
		this.image = image;
	}

}

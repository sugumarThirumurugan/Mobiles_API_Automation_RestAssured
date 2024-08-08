package mobiles.api.Endpoints;

import java.util.ResourceBundle;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import mobiles.api.Payloads.Payloads;

public class Endpoints {

	public static ResourceBundle getUrl() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("Routes");
		return resourceBundle;
	}

	public static Response createMobile(Payloads payloads) {

		String createMobileUrl = getUrl().getString("createMobile");
		Response createMobile=given().contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(payloads)
				.when().post(createMobileUrl);
		return createMobile;
	}

	public static Response getMobile(String id) {
		String getmobileUrl = getUrl().getString("getMobile");
		Response getMobile = given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("id", id)
				.when().get(getmobileUrl);
		return getMobile;
	}

	public static Response updateMobile(String id, Payloads payloads) {
		String updateMobileUrl = getUrl().getString("updateMobile");
		Response updateMobile = given().accept(ContentType.JSON).contentType(ContentType.JSON)
				.body(payloads).pathParam("id", id)
				.when().put(updateMobileUrl);
		return updateMobile;
	}

	public static Response deleteMobile(String id) {
		String deleteMobileUrl = getUrl().getString("deleteMobile");
		Response deleteMobile = given().accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("id", id)
				.when().delete(deleteMobileUrl);
		return deleteMobile;


	}

}








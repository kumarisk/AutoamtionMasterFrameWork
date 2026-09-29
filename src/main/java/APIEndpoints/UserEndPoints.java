package APIEndpoints;

import APIPayloads.User;
import APIRoutes.Routes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class UserEndPoints {
	
	public static Response createUser(User payload) {
		
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)		
		.when()
		 	.post(Routes.user_create_post);
		
		return response;
	}
	
	public static Response getUser(String userName) {
		
		Response response = given()
			.pathParam("username",userName)		
		.when()
		 	.get(Routes.user_get);
		
		return response;
	}
	
	public static Response updateUser(String username, User payload) {
		
		Response response = given()
			.pathParam("username",username)	
			.body(payload)
		.when()
		 	.put(Routes.user_update_put);
		
		return response;
	}

	
	public static Response logoutUser(String username) {
		
		Response response = given()
			.pathParam("username",username)		
		.when()
		 	.get(Routes.user_logout_get);
		
		return response;
	}
	
	public static Response deleteUser(String username) {
		
		Response response = given()
			.pathParam("username",username)		
		.when()
		 	.delete(Routes.user_delete);
		
		return response;
	}

}

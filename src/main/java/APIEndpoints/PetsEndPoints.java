package APIEndpoints;

import static io.restassured.RestAssured.given;
import APIPayloads.Pets;
import APIRoutes.Routes;
import io.restassured.response.Response;

public class PetsEndPoints {
	
	
	public static Response createPet(Pets payload) {
		
		Response res = given()
			.contentType("application/json")
			.body(payload)
		.when()
			.post(Routes.add_pets);
		
		return res;
	}
	
	public static void setImageToPet() {
		
		given()
		
		.when()
			.post(Routes.upload_pet_image);
		
		
	}

	public static Response updatepet(Pets payload) {
	
		Response res = given()
			.contentType("application/json")
			.body(payload)
		.when()
			.put(Routes.update_pet);
		
		return res;
	
}
	
	public static Response findPetByStatus(String Status) {
		
		Response res = given()
			.contentType("application/json")
			.queryParam("status", Status)
		.when()
			.get(Routes.find_pet_ByStatus);
		
		return res;
	}
	
	
	public static Response findPetById(int petid) {
		
		Response res = given()
			.contentType("application/json")
			.pathParam("petId", petid)
		.when()
			.get(Routes.find_pet_ById);
		
		return res;
	}
	
	
	public static void updatePetFormData() {
		
		given()
		
		.when()
			.post(Routes.update_pet_formData);
		
		
	}
	
	
	public static Response deletePet(int petid) {
		
		Response res = given()
			.contentType("application/json")
			.pathParam("petId", petid)
		.when()
			.delete(Routes.delete_pet);
		
		return res;		
		
	}

}

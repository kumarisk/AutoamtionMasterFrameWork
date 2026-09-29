package APIEndpoints;


import static io.restassured.RestAssured.given;
import APIPayloads.Store;
import APIRoutes.Routes;
import io.restassured.response.Response;

public class StoreEndPoints {
	
	
	public static Response getInventoryStatus() {
		
		Response res = given()
			.contentType("application/json")
		.when()
			.get(Routes.store_get);
		
		return res;
			
	}
	
	
	public static Response placeOrder(Store payload) {
		
		Response res = given()
			.contentType("application/json")
			.body(payload)
		.when()
			.post(Routes.store_post);
		
		return res;
		
	}
	
	public static Response getOrderDetailsByID(int id) {
		
		Response res = given()
			.contentType("application/json")
			.pathParam("orderid",id)
		.when()
			.get(Routes.store_purchase_get);
		
			return res;
	}
	
	public static Response deleteOrderByID(int id) {
		
		Response res = given()
			.contentType("application/json")
			.pathParam("orderid",id)
		.when()
			.delete(Routes.store_delete);
		
		return res;
	}

}

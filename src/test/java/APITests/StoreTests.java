package APITests;


import APIEndpoints.StoreEndPoints;
import APIPayloads.Store;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import io.restassured.response.Response;

public class StoreTests {

	public static Logger log = LogManager.getLogger(StoreTests.class.getName());

	Store store;
	
	
	@BeforeClass
	public void setup() {

		Faker fake = new Faker();
		store = new Store();
		store.setId(1);
		store.setPetId(0);
		store.setQuantity(1);
		store.setShipDate("2024-07-06T04:38:39.896Z");
		store.setStatus("placed");
		store.setComplete(true);
	}
	
	
	
	@Test(priority =1)
	public void getStoreStatus() {
		log.info("Trying to get Store inventory status");
		Response response = StoreEndPoints.getInventoryStatus();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		log.info("Retrived Store Inventory status");
	}
	
	@Test(priority =2)
	public void placeStoreOrder() {
		log.info("Trying to place an order");
		Response response = StoreEndPoints.placeOrder(store);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		log.info("Order placed successfully");
	}
	
	
	@Test(priority =3)
	public void getOrderIDdetails() {
		log.info("Retrive the order details based on OrderID");
		Response response = StoreEndPoints.getOrderDetailsByID(this.store.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		log.info("Successfully retrived the Order details based on OrderID");
	}
	
	@Test(priority =4)
	public void deleteOrderID() {
		log.info("Trying to delete Order based on OrderID");
		Response response = StoreEndPoints.deleteOrderByID(this.store.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		log.info("Order deleted successfully");
	}
	

}

package APITests;


import APIEndpoints.UserEndPoints;
import APIPayloads.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.App;
import com.github.javafaker.Faker;
import io.restassured.response.Response;

public class UserTests {

	public static Logger log = LogManager.getLogger(UserTests.class.getName());
	
	Faker faker;
	User userpayloads;
		
	@BeforeClass
	public void setUpData() {
		
		faker = new Faker();
		userpayloads = new User();
		
		userpayloads.setId(faker.idNumber().hashCode());
		userpayloads.setUsername(faker.name().username());
		userpayloads.setFirstName(faker.name().firstName());
		userpayloads.setLastName(faker.name().lastName());
		userpayloads.setEmail(faker.internet().safeEmailAddress());
		userpayloads.setPassword(faker.internet().password(5, 10));
		userpayloads.setPhone(faker.phoneNumber().cellPhone());
		

	}
	
	@Test(priority=1)
	public void testPostUser() {
		log.info("Trying to Create New User");
		Response response = UserEndPoints.createUser(userpayloads);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		log.info("New User created Successfully");
	}
	
	@Test(priority=2)
	public void getuserdetails() {
		log.info("Trying to retrive user Details");
		Response response = UserEndPoints.getUser(this.userpayloads.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		log.info("User Details reteived Successfully");
	}
	
	@Test(priority=3)
	public void updatedetails() {
		log.info("Trying to Update User Details");
	//updating the firstname,lastname, and email address	
		userpayloads.setFirstName(faker.name().firstName());
		userpayloads.setLastName(faker.name().lastName());
		userpayloads.setEmail(faker.internet().safeEmailAddress());
		
		Response details = UserEndPoints.updateUser(this.userpayloads.getUsername(), userpayloads);
		details.then().log().all();
		log.info("Successfully updated the User Details");
	//checking the updated data	
		log.info("Trying to retrive Updated user Data");
		Response response = UserEndPoints.getUser(this.userpayloads.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		log.info("Successfully retrived updated User Data");
	}
	
	@Test(priority=4)
	public void deleteuser() {
		log.info("Trying to delete the User");
		Response res = UserEndPoints.deleteUser(this.userpayloads.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		log.info("User deleted Successfully");
	}

}

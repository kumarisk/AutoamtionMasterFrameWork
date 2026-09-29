package APITests;

import APIEndpoints.UserEndPoints;
import APIPayloads.User;
import Utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class DataDrivenTests {
	
	
	
	@Test(priority=1,dataProvider="Data",dataProviderClass= DataProviders.class)
	public void multUsersCreate(String userid,String userName,String fName,String lName,String userEmail,String pwd,String ph) {
		
		User userpayloads = new User();
		
		userpayloads.setId(Integer.parseInt(userid));
		userpayloads.setUsername(userName);
		userpayloads.setFirstName(fName);
		userpayloads.setLastName(lName);
		userpayloads.setEmail(userEmail);
		userpayloads.setPassword(pwd);
		userpayloads.setPhone(ph);
		
		Response response = UserEndPoints.createUser(userpayloads);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void deleteUser(String userName) {
		
		Response res = UserEndPoints.deleteUser(userName);
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}

}

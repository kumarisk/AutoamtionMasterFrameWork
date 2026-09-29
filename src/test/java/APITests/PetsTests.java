package APITests;


import APIEndpoints.PetsEndPoints;
import APIPayloads.Pets;
import MobileTests.MobileLoginPageTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import io.restassured.response.Response;


public class PetsTests {

    public static Logger log = LogManager.getLogger(PetsTests.class.getName());

    Pets pets;

    @BeforeClass
    public void data() {

        pets = new Pets();

        pets.setId(12);
        pets.setCat_id(11);
        pets.setCat_name("Friendly");
        pets.setName("deer");
        pets.setTag_id(1);
        pets.setTag_name("deer1");

    }


    @Test(priority = 1)
    public void createPet() {
        log.info("Creating a Pet");
        Response respo = PetsEndPoints.createPet(pets);
        respo.then().log().all();
        Assert.assertEquals(respo.getStatusCode(), 200);
        log.info("Pet got Created Sucessfully");

    }

    @Test(priority = 2)
    public void updatePet() {
        log.info("Updating the Pet Details");
        Response respo = PetsEndPoints.updatepet(pets);
        respo.then().log().all();
        Assert.assertEquals(respo.getStatusCode(), 200);
        log.info("pet details got updated sucessfully");
    }

    //@Test(priority=3)
    public void findPetStatus() {
        String status = "available";
        log.info("Finding pets that are " +status);//can pass available,sold,pending
        Response respo = PetsEndPoints.findPetByStatus(status);
        respo.then().log().all();
        Assert.assertEquals(respo.getStatusCode(), 200);
        log.info("Found pets that are " +status );
    }

    @Test(priority = 4)
    public void findPetId() {
        log.info("Finding the Pet based on given PetID");
        Response respo = PetsEndPoints.findPetById(pets.getId());
        respo.then().log().all();
        Assert.assertEquals(respo.getStatusCode(), 200);
        log.info("Matching Pet found");
    }


    @Test(priority = 5)
    public void deletePet() {
        log.info("Deleting the Pet based on PetID");
        Response respo = PetsEndPoints.deletePet(pets.getId());
        respo.then().log().all();
        Assert.assertEquals(respo.getStatusCode(), 200);
        log.info("Matching Pet deleted sucessfully");
    }

}

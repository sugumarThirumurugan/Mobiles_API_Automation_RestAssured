package mobiles.api.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;
import mobiles.api.Endpoints.Endpoints;
import mobiles.api.Payloads.Payloads;

public class MobileTestcases {
	
	Payloads payloads;
	Faker faker;
	String createdMobileId;
	
	@Test(priority=1,dataProvider = "ExcelData",dataProviderClass = mobiles.api.Utilities.DataProviderClass.class)
	public void dataGeneration(String data[]) {
		 payloads = new Payloads();
		 faker = new Faker();
		 payloads.setMobileName(data[0]);
		 payloads.setMobileVersion(data[1]);
		 payloads.setRam(data[2]);
		 payloads.setBattery(faker.phoneNumber().cellPhone());	
		 
		 //Calling all the Test Methods
		 createMobile();
		 getMobileMobile();
		 updateMobile();
		 deleteMobile();
	}
	
	public void createMobile() {
		Response createMobileResponse = Endpoints.createMobile(payloads);
		try {
		createdMobileId = createMobileResponse.jsonPath().get("id");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Assert.assertEquals(createMobileResponse.getStatusCode(), 201);
		Assert.assertEquals(createMobileResponse.getStatusLine(), "HTTP/1.1 201 Created");
		createMobileResponse.then().log().body();
		
	}
	
	public void getMobileMobile() {
		String getMobileId=null;
		Response getMobileResponse = Endpoints.getMobile(createdMobileId);
		try {
			 getMobileId = getMobileResponse.jsonPath().get("id");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Assert.assertEquals(getMobileId, createdMobileId);
		Assert.assertEquals(getMobileResponse.getStatusCode(),200);
		Assert.assertEquals(getMobileResponse.getStatusLine(), "HTTP/1.1 200 OK");
		getMobileResponse.then().log().body();
		
	}
	
	public void updateMobile() {
		String updateMobileId=null;
		faker=new Faker();
		 payloads.setBattery(faker.phoneNumber().cellPhone());
		Response updateMobileResponse = Endpoints.updateMobile(createdMobileId,payloads);
		try {
			updateMobileId = updateMobileResponse.jsonPath().get("id");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Assert.assertEquals(updateMobileId, createdMobileId);
		Assert.assertEquals(updateMobileResponse.getStatusCode(), 200);
		Assert.assertEquals(updateMobileResponse.getStatusLine(), "HTTP/1.1 200 OK");
		updateMobileResponse.then().log().body();
		
	}
	
	public void deleteMobile() {
		String deleteMobileId=null;
		Response updateMobileResponse = Endpoints.deleteMobile(createdMobileId);
		try {
			deleteMobileId = updateMobileResponse.jsonPath().get("id");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Assert.assertEquals(deleteMobileId, createdMobileId);
		Assert.assertEquals(updateMobileResponse.getStatusCode(), 200);
		Assert.assertEquals(updateMobileResponse.getStatusLine(), "HTTP/1.1 200 OK");
		updateMobileResponse.then().log().body();
		
	}
	
	
	
	

}





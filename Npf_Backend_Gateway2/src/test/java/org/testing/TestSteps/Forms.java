package org.testing.TestSteps;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testing.utilities.ApiValidation;
import org.testing.utilities.LoadPropertiesFile;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jxl.read.biff.BiffException;

public class Forms {

	
	ApiValidation apiValidation = new ApiValidation();

	public void getCollegeConfigOptions(String URL,String environment) throws IOException, BiffException {
		Properties properties = LoadPropertiesFile.handlePropertyFile("../Npf_Backend_Gateway2/URI.properties");
		UserModule users = new UserModule(properties);
		users.loginBackendUser(URL,environment);
		String access_tokens = users.access_tokens;
		String deviceId = users.deviceId;
		getCollegeConfigOptionsWhatsappNationalConfig(URL, access_tokens, deviceId);
		
	}

	public void getCollegeConfigOptionsWhatsappNationalConfig(String URL, String access_tokens, String deviceId)
			throws FileNotFoundException {

		System.out.println("******************** Get College Config Options Whatsapp National Config ********************\n");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).when()
				.get(URL + "/forms/v1/getCollegeConfigOptions/176/whatsapp_national_config");
		apiValidation.apiValidation(response);

	}
	
}

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

public class User_Permissions {

	
	ApiValidation apiValidation = new ApiValidation();

	public void allBackendUserPermissions(String URL,String environment) throws IOException, BiffException {
		Properties properties = LoadPropertiesFile.handlePropertyFile("../Npf_Backend_Gateway2/URI.properties");
		UserModule users = new UserModule(properties);
		users.loginBackendUser(URL,environment);
		String access_tokens = users.access_tokens;
		String deviceId = users.deviceId;
		getModuleWisePermissionsLeads(URL, access_tokens, deviceId);
		getModuleWisePermissionsFieldForce(URL, access_tokens, deviceId);
		getModuleWisePermissionsTelephony(URL, access_tokens, deviceId);
		getModuleWisePermissionsApplication(URL, access_tokens, deviceId);
		getModuleWisePermissionsCounsellor(URL, access_tokens, deviceId);
	}

	public void getModuleWisePermissionsFieldForce(String URL, String access_tokens, String deviceId)
			throws FileNotFoundException {

		System.out.println("******************** Get Module Wise Permissions Field Force ********************\n");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).when()
				.get(URL + "/permissions/v1/getModuleWisePermissions/176/field_force");
		apiValidation.apiValidation(response);

	}
	
	public void getModuleWisePermissionsLeads(String URL, String access_tokens, String deviceId)
			throws FileNotFoundException {

		System.out.println("******************** Get Module Wise Permissions Leads ********************\n");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).when()
				.get(URL + "/permissions/v1/getModuleWisePermissions/176/leads");
		apiValidation.apiValidation(response);

	}

	public void getModuleWisePermissionsTelephony(String URL, String access_tokens, String deviceId)
			throws FileNotFoundException {

		System.out.println("******************** Get Module Wise Permissions Telephony ********************\n");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).when()
				.get(URL + "/permissions/v1/getModuleWisePermissions/176/telephony");
		apiValidation.apiValidation(response);
	}

	public void getModuleWisePermissionsApplication(String URL, String access_tokens, String deviceId)
			throws FileNotFoundException {

		System.out.println("******************** Get Module Wise Permissions Application ********************\n");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).when()
				.get(URL + "/permissions/v1/getModuleWisePermissions/176/application");
		apiValidation.apiValidation(response);
	}

	public void getModuleWisePermissionsCounsellor(String URL, String access_tokens, String deviceId)
			throws FileNotFoundException {

		System.out.println("******************** Get Module Wise Permissions Counsellor ********************\n");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).when()
				.get(URL + "/permissions/v1/getModuleWisePermissions/176/counsellor");
		apiValidation.apiValidation(response);
	}

}

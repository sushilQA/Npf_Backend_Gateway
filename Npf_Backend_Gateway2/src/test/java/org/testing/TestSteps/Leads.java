package org.testing.TestSteps;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testing.resources.Backend_Gateway_Request;
import org.testing.utilities.ApiValidation;
import org.testing.utilities.LoadPropertiesFile;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jxl.read.biff.BiffException;

public class Leads {

	ApiValidation apiValidation = new ApiValidation();
	Backend_Gateway_Request backend_Gateway_Request = new Backend_Gateway_Request();
	JSONArray jsonArray;

	public void leadsModule(String URL, String environment) throws IOException, BiffException {
		Properties properties = LoadPropertiesFile.handlePropertyFile("../Npf_Backend_Gateway2/URI.properties");
		UserModule users = new UserModule(properties);
		users.loginBackendUser(URL, environment);
		String access_tokens = users.access_tokens;
		String deviceId = users.deviceId;
		getSavedFilterList(URL, access_tokens, deviceId);
		getSavedFilterDetail(URL, access_tokens, deviceId);
		getLMSData(URL, access_tokens, deviceId);

	}

	public void getSavedFilterList(String URL, String access_tokens, String deviceId) throws FileNotFoundException {

		System.out.println("******************** Get Saved Filter List ********************\n");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).when()
				.get(URL + "/leads/v2/getSavedFilterList/176");
		JSONObject jsonObject = new JSONObject(response.asPrettyString());
		JSONObject jsonObject2 = (JSONObject) jsonObject.get("data");
		JSONArray jsonArray = jsonObject2.getJSONArray("list");
		if (jsonArray.isEmpty()) {
			System.out.println("No Saved Filters found");
		} else {

			this.jsonArray = jsonArray;

		}
		apiValidation.apiValidation(response);

	}

	public void getSavedFilterDetail(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Saved Filter Detail ********************\n");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject ob = jsonArray.getJSONObject(i);
			String key = ob.get("id").toString();
			Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key")
					.and().header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request)
					.when().get(URL + "/leads/v2/getSavedFilterDetail/" + key);
			apiValidation.apiValidation(response);
			System.out.println("Executed for saved filter " +ob.get("filterName"));
		}
	}

	public void getLMSData(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get LMS Data ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setPage("0");
		backend_Gateway_Request.setPer_page_record("15");
		backend_Gateway_Request.setMarkAsDefault("false");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/leads/v2/getLMSData");
		apiValidation.apiValidation(response);
	}

}

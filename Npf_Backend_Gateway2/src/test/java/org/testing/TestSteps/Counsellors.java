package org.testing.TestSteps;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testing.resources.Backend_Gateway_Request;
import org.testing.utilities.ApiValidation;
import org.testing.utilities.LoadPropertiesFile;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jxl.read.biff.BiffException;

public class Counsellors {

	ApiValidation apiValidation = new ApiValidation();
	Backend_Gateway_Request backend_Gateway_Request = new Backend_Gateway_Request();

	public void counsellorsModule(String URL,String environment) throws IOException, BiffException {
		Properties properties = LoadPropertiesFile.handlePropertyFile("../Npf_Backend_Gateway2/URI.properties");
		UserModule users = new UserModule(properties);
		users.loginBackendUser(URL,environment);
		String access_tokens = users.access_tokens;
		String deviceId = users.deviceId;
		getCounsellorProductivityMetrics(URL, access_tokens, deviceId);
		getCounsellorProductivityReport(URL, access_tokens, deviceId);
		getCounsellorProductivityReportColumns(URL, access_tokens, deviceId);
		getCounsellorProductivityReportApplicationSummery(URL, access_tokens, deviceId);
		getCounsellorProductivityReportCommunication(URL, access_tokens, deviceId);
		getCounsellorProductivityReportQuery(URL, access_tokens, deviceId);
		getCounsellorListForProductivityReports(URL, access_tokens, deviceId);
		getHeadCounsellorListForProductivityReports(URL, access_tokens, deviceId);
		getCounsellorfollowUps(URL, access_tokens, deviceId);
		getCounsellorfollowUpsListingAll(URL, access_tokens, deviceId);
		getCounsellorfollowUpsListingCompleted(URL, access_tokens, deviceId);
		getCounsellorfollowUpsListingOverdue(URL, access_tokens, deviceId);
		getCounsellorfollowUpsListingToday(URL, access_tokens, deviceId);
		getCounsellorfollowUpsListingUpcoming(URL, access_tokens, deviceId);

	}

	public void getCounsellorfollowUps(String URL, String access_tokens, String deviceId) throws FileNotFoundException {

		System.out.println("******************** Get Counsellor followUps ********************\n");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).when()
				.get(URL + "/counsellors/v1/getCounsellorfollowUps/176");
		apiValidation.apiValidation(response);

	}

	public void getCounsellorfollowUpsListingToday(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Counsellor followUps Listing Today ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setFollowUpType("today");
		backend_Gateway_Request.setShowAll("0");
		backend_Gateway_Request.setSize("5");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/counsellors/v1/getCounsellorfollowUpsListing");
		apiValidation.apiValidation(response);
	}

	public void getCounsellorfollowUpsListingUpcoming(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Counsellor followUps Listing Upcoming ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setFollowUpType("upcoming");
		backend_Gateway_Request.setShowAll("0");
		backend_Gateway_Request.setSize("5");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/counsellors/v1/getCounsellorfollowUpsListing");
		apiValidation.apiValidation(response);
	}

	public void getCounsellorfollowUpsListingOverdue(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Counsellor followUps Listing Overdue ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setFollowUpType("overdue");
		backend_Gateway_Request.setShowAll("0");
		backend_Gateway_Request.setSize("5");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/counsellors/v1/getCounsellorfollowUpsListing");
		apiValidation.apiValidation(response);
	}

	public void getCounsellorfollowUpsListingCompleted(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Counsellor followUps Listing Completed ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setFollowUpType("completed");
		backend_Gateway_Request.setShowAll("0");
		backend_Gateway_Request.setSize("5");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/counsellors/v1/getCounsellorfollowUpsListing");
		apiValidation.apiValidation(response);
	}

	public void getCounsellorfollowUpsListingAll(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Counsellor followUps Listing All ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setFollowUpType("all");
		backend_Gateway_Request.setShowAll("0");
		backend_Gateway_Request.setSize("5");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/counsellors/v1/getCounsellorfollowUpsListing");
		apiValidation.apiValidation(response);
	}

	public void productivityReportQuickView(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Productivity Report QuickView ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/counsellors/v1/productivityReportQuickView");
		apiValidation.apiValidation(response);
	}

	public void getCounsellorProductivityMetrics(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Counsellor Productivity Metrics ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setCounsellor_metrics("true");
		backend_Gateway_Request.setDateRange("05/01/2022,03/02/2022");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/counsellors/v1/getCounsellorProductivityMetrics");
		apiValidation.apiValidation(response);
	}

	public void getCounsellorProductivityReport(String URL, String access_tokens, String deviceId)
			throws FileNotFoundException {
		System.out.println("******************** Get Counsellor Productivity Report Generic ********************\n");
		File file = new File("../Npf_Backend_Gateway/src/test/java/org/testing/resources/getCounsellorProductivityReport.json");
		FileReader fileReader = new FileReader(file);
		JSONTokener jsonTokener = new JSONTokener(fileReader);
		JSONObject jsonObject = new JSONObject(jsonTokener);
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(jsonObject.toString())
				.post(URL + "/counsellors/v2/getCounsellorProductivityReport");
		apiValidation.apiValidation(response);
	}

	public void getCounsellorProductivityReportColumns(String URL, String access_tokens, String deviceId)
			throws FileNotFoundException {

		System.out.println("******************** Get Counsellor Productivity Report Columns ********************\n");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).when()
				.get(URL + "/counsellors/v2/getCounsellorProductivityReportColumns/176/");
		apiValidation.apiValidation(response);

	}

	public void getCounsellorProductivityReportQuery(String URL, String access_tokens, String deviceId)
			throws FileNotFoundException {
		System.out.println("******************** Get Counsellor Productivity Report Query ********************\n");
		File file = new File("../Npf_Backend_Gateway/src/test/java/org/testing/resources/getCounsellorProductivityReportQuery.json");
		
		FileReader fileReader = new FileReader(file);
		JSONTokener jsonTokener = new JSONTokener(fileReader);
		JSONObject jsonObject = new JSONObject(jsonTokener);
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(jsonObject.toString())
				.post(URL + "/counsellors/v2/getCounsellorProductivityReport");
		apiValidation.apiValidation(response);
	}

	public void getCounsellorProductivityReportApplicationSummery(String URL, String access_tokens, String deviceId)
			throws FileNotFoundException {
		System.out.println(
				"******************** Get Counsellor Productivity Report Application Summery ********************\n");
		File file = new File(
				"../Npf_Backend_Gateway/src/test/java/org/testing/resources/getCounsellorProductivityReportApplicationSummery.json");
		FileReader fileReader = new FileReader(file);
		JSONTokener jsonTokener = new JSONTokener(fileReader);
		JSONObject jsonObject = new JSONObject(jsonTokener);
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(jsonObject.toString())
				.post(URL + "/counsellors/v2/getCounsellorProductivityReport");
		apiValidation.apiValidation(response);
	}

	public void getCounsellorProductivityReportCommunication(String URL, String access_tokens, String deviceId)
			throws FileNotFoundException {
		System.out.println(
				"******************** Get Counsellor Productivity Report Communication ********************\n");
		File file = new File(
				"../Npf_Backend_Gateway/src/test/java/org/testing/resources/getCounsellorProductivityReportCommunication.json");
		FileReader fileReader = new FileReader(file);
		JSONTokener jsonTokener = new JSONTokener(fileReader);
		JSONObject jsonObject = new JSONObject(jsonTokener);
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(jsonObject.toString())
				.post(URL + "/counsellors/v2/getCounsellorProductivityReport");
		apiValidation.apiValidation(response);
	}
	
	public void getCounsellorListForProductivityReports(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Counsellor List For Productivity Reports ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/counsellors/v1/getCounsellorListForProductivityReports");
		apiValidation.apiValidation(response);
	}
	public void getHeadCounsellorListForProductivityReports(String URL, String access_tokens, String deviceId)
			throws FileNotFoundException {

		System.out.println("******************** Head Counsellor List For Productivity Reports ********************\n");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).when()
				.get(URL + "/counsellors/v1/headCounsellorListForProductivityReports/176");
		apiValidation.apiValidation(response);

	}
	
}

package org.testing.TestSteps;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testing.resources.Backend_Gateway_Request;
import org.testing.utilities.ApiValidation;
import org.testing.utilities.LoadPropertiesFile;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jxl.read.biff.BiffException;

public class Analytics {

	ApiValidation apiValidation = new ApiValidation();
	Backend_Gateway_Request backend_Gateway_Request = new Backend_Gateway_Request();

	public void analyticsModule(String URL,String environment) throws IOException, BiffException {
		Properties properties = LoadPropertiesFile.handlePropertyFile("../Npf_Backend_Gateway/URI.properties");
		UserModule users = new UserModule(properties);
		users.loginBackendUser(URL,environment);
		String access_tokens = users.access_tokens;
		String deviceId = users.deviceId;
		adminDashboard(URL, access_tokens, deviceId);
		marketingDashboard(URL, access_tokens, deviceId);
		counsellorDashboard(URL, access_tokens, deviceId);
		getApplicationFunnelData(URL, access_tokens, deviceId);
		getConversionFunnelData(URL, access_tokens, deviceId);
		getFormStageWiseSegregation(URL, access_tokens, deviceId);
		getLeadVsApplicationData(URL, access_tokens, deviceId);
		getScoreBoardDataLead(URL, access_tokens, deviceId);
		getScoreBoardDataPaidApplication(URL, access_tokens, deviceId);
		getScoreBoardDataUnPaidApplication(URL, access_tokens, deviceId);
		getScoreBoardDataQueries(URL, access_tokens, deviceId);
		getScoreBoardDataCommunication(URL, access_tokens, deviceId);
		getTopSourcesData(URL, access_tokens, deviceId);
		getGraphFormWiseApplications(URL, access_tokens, deviceId);
		getFormWiseApplications(URL, access_tokens, deviceId);
		getCounsellorWiseFollowups(URL, access_tokens, deviceId);
		getCounsellorVsSubStage(URL, access_tokens, deviceId);

	}

	public void adminDashboard(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Admin Dashboard ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setDashboardName("Admin Dashboard");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/analytics/v2/getDashboardDashlets");
		apiValidation.apiValidation(response);
	}

	public void marketingDashboard(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Marketing Dashboard ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setDashboardName("Marketing Dashboard");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/analytics/v2/getDashboardDashlets");
		apiValidation.apiValidation(response);
	}
	
	public void counsellorDashboard(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Counsellor Dashboard ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setDashboardName("Counsellor Dashboard");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/analytics/v2/getDashboardDashlets");
		apiValidation.apiValidation(response);
	}

	public void getApplicationFunnelData(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Application Funnel Data ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setStartDate("");
		backend_Gateway_Request.setEndDate("");
		backend_Gateway_Request.setFormId("15077");

		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/analytics/v1/getApplicationFunnelData");
		apiValidation.apiValidation(response);
	}

	public void getTopSourcesData(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Top Sources Data ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setStartDate("");
		backend_Gateway_Request.setEndDate("");

		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/analytics/v1/getTopSourcesData");
		apiValidation.apiValidation(response);
	}

	public void getScoreBoardDataLead(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Score Board Data Lead ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setStartDate("2021-10-01");
		backend_Gateway_Request.setEndDate("2021-12-31");
		backend_Gateway_Request.setRangeEndDate("");
		backend_Gateway_Request.setRangeStartDate("");
		backend_Gateway_Request.setType("lead");

		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/analytics/v2/getScoreBoardData");
		apiValidation.apiValidation(response);
	}

	public void getScoreBoardDataPaidApplication(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Score Board Data Paid Application ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setStartDate("2021-10-01");
		backend_Gateway_Request.setEndDate("2021-12-31");
		backend_Gateway_Request.setRangeEndDate("");
		backend_Gateway_Request.setRangeStartDate("");
		backend_Gateway_Request.setType("paidApplication");

		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/analytics/v2/getScoreBoardData");
		apiValidation.apiValidation(response);
	}

	public void getScoreBoardDataUnPaidApplication(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Score Board Data UnPaid Application ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setStartDate("2021-10-01");
		backend_Gateway_Request.setEndDate("2021-12-31");
		backend_Gateway_Request.setRangeEndDate("");
		backend_Gateway_Request.setRangeStartDate("");
		backend_Gateway_Request.setType("unPaidApplication");

		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/analytics/v2/getScoreBoardData");
		apiValidation.apiValidation(response);
	}

	public void getScoreBoardDataQueries(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Score Board Data Queries ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setStartDate("2021-10-01");
		backend_Gateway_Request.setEndDate("2021-12-31");
		backend_Gateway_Request.setRangeEndDate("");
		backend_Gateway_Request.setRangeStartDate("");
		backend_Gateway_Request.setType("queries");

		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/analytics/v2/getScoreBoardData");
		apiValidation.apiValidation(response);
	}

	public void getScoreBoardDataCommunication(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Score Board Data Communication ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setStartDate("2021-10-01");
		backend_Gateway_Request.setEndDate("2021-12-31");
		backend_Gateway_Request.setRangeEndDate("");
		backend_Gateway_Request.setRangeStartDate("");
		backend_Gateway_Request.setType("communication");

		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/analytics/v2/getScoreBoardData");
		apiValidation.apiValidation(response);
	}

	public void getConversionFunnelData(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Conversion Funnel Data ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setStartDate("");
		backend_Gateway_Request.setEndDate("");

		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/analytics/v1/getConversionFunnelData");
		apiValidation.apiValidation(response);
	}

	public void getLeadVsApplicationData(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Lead Vs Application Data ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setStartDate("");
		backend_Gateway_Request.setEndDate("");

		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/analytics/v1/getLeadVsApplicationData");
		apiValidation.apiValidation(response);
	}

	public void getFormStageWiseSegregation(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Form Stage Wise Segregation ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setStartDate("");
		backend_Gateway_Request.setEndDate("");
		backend_Gateway_Request.setFormId("15077");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/analytics/v1/getFormStageWiseSegregation");
		apiValidation.apiValidation(response);
	}

	public void getFormWiseApplications(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Form Wise Applications ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/analytics/v1/getFormWiseApplications");
		apiValidation.apiValidation(response);
	}

	public void getGraphFormWiseApplications(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Graph Form Wise Applications ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setFormId("15077");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/analytics/v1/getGraphFormWiseApplications");
		apiValidation.apiValidation(response);
	}
	
	public void getCounsellorVsStageLead(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Counsellor Vs Stage Lead ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setModuleName("lead");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/analytics/v1/getCounsellorVsStage");
		apiValidation.apiValidation(response);
	}
	
	public void getCounsellorVsStageApplication(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Counsellor Vs Stage Application ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setFormId("15077");
		backend_Gateway_Request.setModuleName("application");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/analytics/v1/getCounsellorVsStage");
		apiValidation.apiValidation(response);
	}
	
	public void getCounsellorWiseFollowups(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Counsellor Wise Followups ********************\n");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/analytics/v1/getCounsellorWiseFollowups/176");
		apiValidation.apiValidation(response);
	}
	
	public void getCounsellorVsSubStage(String URL, String access_tokens, String deviceId) {
		System.out.println("******************** Get Counsellor Vs Sub Stage Lead ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setFormId("16457");
		backend_Gateway_Request.setModuleName("lead");
		backend_Gateway_Request.setStageId("20152");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/analytics/v1/getCounsellorVsSubStage");
		apiValidation.apiValidation(response);
	}

}

package org.testing.TestSteps;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.Properties;

import org.eclipse.jdt.internal.compiler.codegen.ExceptionLabel;
import org.json.JSONObject;
import org.testing.resources.Backend_Gateway_Request;
import org.testing.resources.Field_Force_Request_Body;
import org.testing.resources.LoadUaerModuleData;
import org.testing.resources.User_App_Settings;
import org.testing.utilities.ApiValidation;
import org.testing.utilities.ExcelDataRead;

import io.restassured.response.*;
import jxl.read.biff.BiffException;
import io.restassured.http.ContentType;

public class UserModule {

	Properties properties;
	String access_tokens;
	String deviceId;
	User_App_Settings appSettings = new User_App_Settings();
	Backend_Gateway_Request backend_Gateway_Request = new Backend_Gateway_Request();
	ApiValidation apiValidation = new ApiValidation();
	LoadUaerModuleData loadUaerModuleData = new LoadUaerModuleData();

	public UserModule(Properties properties) {
		this.properties = properties;
	}

	public void usersModule(String uriKey ,String environment) throws IOException, BiffException {

		emailAuth(uriKey,environment);
		loginBackendUser(uriKey,environment);
		checkPasswordExpired(uriKey, access_tokens, deviceId);
		getCollegeList(uriKey, access_tokens, deviceId);
		getCollegeDetails(uriKey, access_tokens, deviceId);
		getHeadCounsellorList(uriKey, access_tokens, deviceId);
		updateUserDeviceAndAppInfo(uriKey, access_tokens, deviceId);
		formList(uriKey, access_tokens, deviceId);
		updateAppPreferences(uriKey, access_tokens, deviceId);
		logoutBackendUser(uriKey);
		forgotPasswordBackendUser(uriKey,environment);
		resetPasswordBackendUser(uriKey ,environment);

	}

	public void fieldForce(String URL,String environment) throws BiffException, IOException {

		loginBackendUser(URL,environment);
		markCheckinCheckout(URL, access_tokens, deviceId);
		getCurrentAttendanceDetails(URL, access_tokens, deviceId);
		getCheckinCheckoutDetails(URL, access_tokens, deviceId);
		getAttendanceBreakdown(URL, access_tokens, deviceId);
		getLocationHistory(URL, access_tokens, deviceId);
		updateLocationByLatLong(URL, access_tokens, deviceId);
		trackLocation(URL, access_tokens, deviceId);

	}

	public void emailAuth(String uriKey,String environment) throws BiffException, IOException {
		System.out.println("******************** Email Auth ********************\n");
		backend_Gateway_Request.setEmail(ExcelDataRead.readACell(environment,1, 0));
		Response response = given().contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(uriKey + "/users/v1/emailAuth");
		apiValidation.apiValidation(response);
	}

	public void loginBackendUser(String URL,String environment) throws BiffException, IOException {
		System.out.println("******************** Backend User Login ********************\n");
		backend_Gateway_Request.setEmail(ExcelDataRead.readACell(environment,2, 0));
		backend_Gateway_Request.setPassword(ExcelDataRead.readACell(environment, 2, 1));
		/*backend_Gateway_Request.setEmail("sushil.k@yopmail.com");
		backend_Gateway_Request.setPassword("Test@123456");*/
		backend_Gateway_Request.setDeviceId("Oppo A1");
		backend_Gateway_Request.setDeviceOs("android");
		backend_Gateway_Request.setFcmToken("dPxK-km7Qb6J-jjWPj8F26:APA91bFbYWAG1wjuPzUGEM6LUZUUGnH3Ir"
				+ "CpAB77fyeh0BNEwO2SCJAZ9Ru942XJt7i92xX6XP6ETKG2lfzO4LwAZKLm"
				+ "5cT2Imk7L7xM6vVf3cVuQQesacaeeRPuTpTCgDBBXBQYKpnl");
		backend_Gateway_Request.setRememberMe("");
		backend_Gateway_Request.setAppType("backend");
		backend_Gateway_Request.setMode("android");
		Response response = given().contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/users/v2/login");
		JSONObject jsonObject = new JSONObject(response.asPrettyString());
		JSONObject jsonObject2 = (JSONObject) jsonObject.get("data");
		if(jsonObject.get("message").toString().contains("Incorrect password"))
		{
			System.out.println(jsonObject.get("message").toString());
		}
		else {
		this.access_tokens = jsonObject2.get("accessToken").toString();
		this.deviceId = jsonObject2.get("deviceId").toString();
		}
		apiValidation.apiValidation(response);

	}

	public void logoutBackendUser(String URL) {
		System.out.println("******************** Backend User Logout  ********************\n");
		backend_Gateway_Request.setDeviceId("Oppo A1");
		Response response = given().contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/users/v2/logout");
		apiValidation.apiValidation(response);

	}

	public void forgotPasswordBackendUser(String URL,String environment) throws BiffException, IOException {
		System.out.println("******************** Forgot Password ********************\n");
		backend_Gateway_Request.setEmail(ExcelDataRead.readACell(environment,1, 0));
		backend_Gateway_Request.setAppType("backend");
		backend_Gateway_Request.setMode("android");
		Response response = given().contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/users/v1/forgot");
		apiValidation.apiValidation(response);

	}

	public void resetPasswordBackendUser(String URL,String environment) throws BiffException, IOException {
		System.out.println("******************** Reset Password ********************\n");
		backend_Gateway_Request.setEmail(ExcelDataRead.readACell(environment,1, 0));
		backend_Gateway_Request.setPassword(ExcelDataRead.readACell(environment, 1, 1));
		backend_Gateway_Request.setVerifyPassword("Test@1234");
		backend_Gateway_Request.setUniqueId("abcdef-1234-xyz");
		backend_Gateway_Request.setAppType("backend");
		backend_Gateway_Request.setMode("android");
		Response response = given().contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/users/v1/resetPassword");
		apiValidation.apiValidation(response);

	}

	public void checkPasswordExpired(String URL, String access_tokens, String deviceId) {

		System.out.println("******************** Check Password Expired ********************\n");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).when()
				.post(URL + "/users/v1/checkPasswordExpired");
		apiValidation.apiValidation(response);

	}

	public void getCollegeList(String URL, String access_tokens, String deviceId) {

		System.out.println("******************** Get College List ********************\n");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).when().get(URL + "/users/v2/collegeList");
		apiValidation.apiValidation(response);

	}

	public void getCollegeDetails(String URL, String access_tokens, String deviceId) {

		System.out.println("******************** Get College Details ********************\n");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).when()
				.get(URL + "/users/v1/getCollegeDetails/176");
		apiValidation.apiValidation(response);

	}

	public void getHeadCounsellorList(String URL, String access_tokens, String deviceId) {

		System.out.println("******************** Get HeadCounsellor List ********************\n");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).when()
				.get(URL + "/users/v1/getHeadCounsellors/176");
		apiValidation.apiValidation(response);

	}

	public void updateUserDeviceAndAppInfo(String URL, String access_tokens, String deviceId) {

		System.out.println("******************** Update User Device And App Info ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setAppUpdate("true");
		backend_Gateway_Request.setDeviceBrand("Realme");
		backend_Gateway_Request.setDeviceId("Oppo A1");
		backend_Gateway_Request.setDeviceModel("RMX3430");
		backend_Gateway_Request.setDeviceOs("Android");
		backend_Gateway_Request.setHasTrueCaller("True");
		backend_Gateway_Request.setInstituteName("Testing Institute");
		backend_Gateway_Request.setNpfAppVersion("3.3.0");
		backend_Gateway_Request.setNpfTrackerAppVersion("1.13");
		backend_Gateway_Request.setOsVersion("Android 11 (30)");
		backend_Gateway_Request.setUserName("SUSHIL");
		backend_Gateway_Request.setUserRole("Counsellor");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/users/v1/updateUserDeviceAndAppInfo/176");
		apiValidation.apiValidation(response);

	}

	public void updateAppPreferences(String URL, String access_tokens, String deviceId) {

		System.out.println("******************** Update App Preferences ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setUpdated("1643204126");
		backend_Gateway_Request.setPartialUpdate("true");
		appSettings.setIsTrackerAbsent("false");
		appSettings.setMainOverlaySwitch("false");
		appSettings.setMainPermissionOverLay("true");
		appSettings.setMainPermissionStorage("true");
		appSettings.setMainRecordingSwitch("false");
		appSettings.setMainTrackingSwitch("false");
		appSettings.setTrackerPermissionCallLog("true");
		appSettings.setTrackerPermissionPhoneCall("true");
		appSettings.setTrackerPermissionPhoneState("true");
		appSettings.setTrackerPermissionReadContact("true");
		appSettings.setTrackerPermissionRecording("true");
		appSettings.setTrackerPermissionStorage("true");
		appSettings.setTrackerPermissionTracking("true");
		appSettings.setTrackingPermissionRecording("true");
		backend_Gateway_Request.setAppSettings(appSettings);
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/users/v1/updateAppPreferences/176");
		System.out.println(response.asPrettyString());
		// apiValidation.apiValidation(response);

	}

	public void formList(String URL, String access_tokens, String deviceId) {

		System.out.println("******************** Form List ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setShowAllForm("true");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/users/v1/formList");
		apiValidation.apiValidation(response);

	}

	public void markCheckinCheckout(String URL, String access_tokens, String deviceId) {

		System.out.println("******************** Mark Checkin Checkout ********************\n");
		backend_Gateway_Request.setBattery_percentage("95");
		backend_Gateway_Request.setLocation_accuracy("20.0");
		backend_Gateway_Request.setAddress("9, Old Delhi Rd, Sector 12,"
				+ " Dharam Colony, Palam Vihar Extension, Gurugram, Haryana 122017, India,");
		backend_Gateway_Request.setDevice_type("Android Mobile App");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setLat("28.5003695");
		backend_Gateway_Request.setLong("77.0331542");
		backend_Gateway_Request.setStatus("checkin");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/users/v1/markCheckinCheckout/176");
		apiValidation.apiValidation(response);

	}

	public void getCurrentAttendanceDetails(String URL, String access_tokens, String deviceId) {

		System.out.println("******************** Get Current Attendance Details ********************\n");
		backend_Gateway_Request.setBattery_percentage("95");
		backend_Gateway_Request.setLocation_accuracy("20.0");
		backend_Gateway_Request.setDevice_type("Android Mobile App");
		backend_Gateway_Request.setCollegeId("176");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/users/v1/getCurrentAttendanceDetails/176");
		apiValidation.apiValidation(response);

	}

	public void getCheckinCheckoutDetails(String URL, String access_tokens, String deviceId) {

		System.out.println("******************** Get Checkin Checkout Details ********************\n");
		backend_Gateway_Request.setBattery_percentage("95");
		backend_Gateway_Request.setLocation_accuracy("20.0");
		backend_Gateway_Request.setDevice_type("Android Mobile App");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setStart_date("01/01/2022");
		backend_Gateway_Request.setEnd_date("31/01/2022");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/users/v1/getCheckinCheckoutDetails/176");
		apiValidation.apiValidation(response);

	}

	public void getAttendanceBreakdown(String URL, String access_tokens, String deviceId) {

		System.out.println("******************** Get Attendance Breakdown ********************\n");
		backend_Gateway_Request.setBattery_percentage("95");
		backend_Gateway_Request.setLocation_accuracy("20.0");
		backend_Gateway_Request.setDevice_type("Android Mobile App");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setDate("22/01/2022");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/users/v1/getAttendanceBreakdown/176");
		apiValidation.apiValidation(response);

	}

	public void getLocationHistory(String URL, String access_tokens, String deviceId) {

		System.out.println("******************** Get Location History ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setDate("22/01/2022");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/users/v1/getLocationHistory");
		apiValidation.apiValidation(response);

	}

	public void updateLocationByLatLong(String URL, String access_tokens, String deviceId) {

		System.out.println("******************** Update Location By Lat Long ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setDate("22/01/2022");
		backend_Gateway_Request.setLat("28.5003695");
		backend_Gateway_Request.setLong("77.0331542");
		backend_Gateway_Request.setLocation("9, Old Delhi Rd, Sector 12,"
				+ " Dharam Colony, Palam Vihar Extension, Gurugram, Haryana 122017, India,");
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/users/v1/updateLocationByLatLong");
		apiValidation.apiValidation(response);

	}

	public void trackLocation(String URL, String access_tokens, String deviceId) {

		System.out.println("******************** Track Location ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		Field_Force_Request_Body[] ff_data = new Field_Force_Request_Body[5];
		ff_data[0] = new Field_Force_Request_Body();
		System.out.println(ff_data[0]);
		ff_data[0].setAddress("Faridabad, ABC test sector 56 Faridabad");
		ff_data[0].setBattery_percentage("95");
		ff_data[0].setDate("22/01/2022");
		ff_data[0].setHas_manual_time("false");
		ff_data[0].setLat("28.4089");
		ff_data[0].setLong("77.3178");
		ff_data[0].setMode("tracking");
		ff_data[0].setStatus("checkin");
		ff_data[0].setTimestamp("1624973110");
		backend_Gateway_Request.setFf_data(ff_data);
		Response response = given().header("access-token", access_tokens).and().header("access-key", "access-key").and()
				.header("deviceId", deviceId).contentType(ContentType.JSON).body(backend_Gateway_Request).when()
				.post(URL + "/users/v1/trackLocation");
		apiValidation.apiValidation(response);
	}
}

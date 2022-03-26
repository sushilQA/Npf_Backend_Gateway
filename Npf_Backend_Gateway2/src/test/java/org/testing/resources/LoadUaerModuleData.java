package org.testing.resources;

public class LoadUaerModuleData {

	User_App_Settings appSettings = new User_App_Settings();
	Backend_Gateway_Request backend_Gateway_Request = new Backend_Gateway_Request();
	
	public Backend_Gateway_Request emailAuth() {
		System.out.println("******************** Email Auth ********************\n");
		backend_Gateway_Request.setEmail("sushil.k@yopmail.com");
		return backend_Gateway_Request;
	}

	public Backend_Gateway_Request loginBackendUser() {
		System.out.println("******************** Backend User Login ********************\n");
		backend_Gateway_Request.setEmail("sushil.k@yopmail.com");
		backend_Gateway_Request.setPassword("Test@1234");
		backend_Gateway_Request.setDeviceId("Oppo A1");
		backend_Gateway_Request.setDeviceOs("android");
		backend_Gateway_Request.setFcmToken("dPxK-km7Qb6J-jjWPj8F26:APA91bFbYWAG1wjuPzUGEM6LUZUUGnH3Ir"
				+ "CpAB77fyeh0BNEwO2SCJAZ9Ru942XJt7i92xX6XP6ETKG2lfzO4LwAZKLm"
				+ "5cT2Imk7L7xM6vVf3cVuQQesacaeeRPuTpTCgDBBXBQYKpnl");
		backend_Gateway_Request.setRememberMe("");
		backend_Gateway_Request.setAppType("backend");
		backend_Gateway_Request.setMode("android");
		return backend_Gateway_Request;

	}

	public Backend_Gateway_Request logoutBackendUser() {
		System.out.println("******************** Backend User Logout  ********************\n");
		backend_Gateway_Request.setDeviceId("Oppo A1");
		return backend_Gateway_Request;

	}

	public Backend_Gateway_Request forgotPasswordBackendUser() {
		System.out.println("******************** Forgot Password ********************\n");
		backend_Gateway_Request.setEmail("sushil.k@yopmail.com");
		backend_Gateway_Request.setAppType("backend");
		backend_Gateway_Request.setMode("android");
		return backend_Gateway_Request;

	}

	public Backend_Gateway_Request resetPasswordBackendUser() {
		System.out.println("******************** Reset Password ********************\n");
		backend_Gateway_Request.setEmail("sushil.k@yopmail.com");
		backend_Gateway_Request.setPassword("Test@1234");
		backend_Gateway_Request.setVerifyPassword("Test@1234");
		backend_Gateway_Request.setUniqueId("abcdef-1234-xyz");
		backend_Gateway_Request.setAppType("backend");
		backend_Gateway_Request.setMode("android");
		return backend_Gateway_Request;

	}

	public String checkPasswordExpired() {

		System.out.println("******************** Check Password Expired ********************\n");
		return backend_Gateway_Request.toString();

	}

	public String getCollegeList() {

		System.out.println("******************** Get College List ********************\n");
		return backend_Gateway_Request.toString();

	}

	public String getCollegeDetails() {

		System.out.println("******************** Get College Details ********************\n");
		return backend_Gateway_Request.toString();

	}

	public String getHeadCounsellorList() {

		System.out.println("******************** Get HeadCounsellor List ********************\n");
		return backend_Gateway_Request.toString();

	}

	public Backend_Gateway_Request updateUserDeviceAndAppInfo() {

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
		return backend_Gateway_Request;

	}

	public Backend_Gateway_Request updateAppPreferences() {

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
		return backend_Gateway_Request;

	}

	public Backend_Gateway_Request formList() {

		System.out.println("******************** Form List ********************\n");
		backend_Gateway_Request.setCollegeId("176");
		backend_Gateway_Request.setShowAllForm("true");
		return backend_Gateway_Request;

	}

}

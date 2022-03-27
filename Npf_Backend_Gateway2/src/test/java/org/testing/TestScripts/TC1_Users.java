package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;
import org.testing.TestSteps.UserModule;
import org.testing.utilities.ApiValidation;
import org.testing.utilities.GenerateExtentReports;
import org.testing.utilities.LoadPropertiesFile;
import org.testingAssertion.Assertion;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import jxl.read.biff.BiffException;

public class TC1_Users {
	
	@Test(priority=1)
	public void usersModule() throws IOException, BiffException {
		System.out.println("User Module");
		ExtentReports extentReports = GenerateExtentReports.generateExtentReport();
		ExtentTest extentTest = extentReports.startTest("Test Name = User Module");
		Properties properties = LoadPropertiesFile.handlePropertyFile("../Npf_Backend_Gateway2/URI.properties");
		UserModule userModule = new UserModule(properties);
		Response response= userModule.usersModule(properties.getProperty("In1"),"Live");
		ApiValidation apiValidation = new ApiValidation();
		String message = apiValidation.apiValidation(response); 
		if(Assertion.assertEqualsIgnoreCase(message, "Api is working fine"))
		{
			extentTest.log(LogStatus.PASS,message);
		}
		else
		{
			extentTest.log(LogStatus.FAIL,message);

		}
		extentReports.endTest(extentTest);
		extentReports.flush();
	}
	
	/*@Test(priority = 2)
	public void fieldForce() throws IOException, BiffException {
		System.out.println("Field Force");
		Properties properties = LoadPropertiesFile.handlePropertyFile("../Npf_Backend_Gateway2/URI.properties");
		UserModule userModule = new UserModule(properties);
		userModule.fieldForce(properties.getProperty("In1"),"Live");
	}*/

}

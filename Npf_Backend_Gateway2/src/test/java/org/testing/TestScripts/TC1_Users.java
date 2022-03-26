package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;
import org.testing.TestSteps.UserModule;
import org.testing.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;

public class TC1_Users {
	
	@Test(priority=1)
	public void usersModule() throws IOException, BiffException {
		System.out.println("User Module");
		Properties properties = LoadPropertiesFile.handlePropertyFile("../Npf_Backend_Gateway2/URI.properties");
		UserModule userModule = new UserModule(properties);
		userModule.usersModule(properties.getProperty("In1"),"Live");
	}
	
	@Test(priority = 2)
	public void fieldForce() throws IOException, BiffException {
		System.out.println("Field Force");
		Properties properties = LoadPropertiesFile.handlePropertyFile("../Npf_Backend_Gateway2/URI.properties");
		UserModule userModule = new UserModule(properties);
		userModule.fieldForce(properties.getProperty("In1"),"Live");
	}

}

package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;
import org.testing.TestSteps.Analytics;
import org.testing.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;

public class TC3_Analytics {

	@Test
	public void analyticsModule() throws IOException, BiffException {
		System.out.println("Analytics Controler");
		Properties properties = LoadPropertiesFile.handlePropertyFile("../Npf_Backend_Gateway2/URI.properties");
		Analytics analytics = new Analytics();
		analytics.analyticsModule(properties.getProperty("In1"),"Live");
	}

}

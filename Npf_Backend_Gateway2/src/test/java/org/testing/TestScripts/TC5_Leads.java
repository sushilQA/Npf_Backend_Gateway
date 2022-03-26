package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;
import org.testing.TestSteps.Analytics;
import org.testing.TestSteps.Counsellors;
import org.testing.TestSteps.Leads;
import org.testing.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;

public class TC5_Leads {

	@Test
	public void counsellorModule() throws IOException, BiffException {
		System.out.println("Leads");
		Properties properties = LoadPropertiesFile.handlePropertyFile("../Npf_Backend_Gateway/URI.properties");
		Leads leads = new Leads();
		leads.leadsModule(properties.getProperty("In1"),"Live");
	}

}

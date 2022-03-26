package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;
import org.testing.TestSteps.Analytics;
import org.testing.TestSteps.Counsellors;
import org.testing.TestSteps.Forms;
import org.testing.TestSteps.Leads;
import org.testing.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;

public class TC6_Forms {

	@Test
	public void counsellorModule() throws IOException, BiffException {
		System.out.println("Forms");
		Properties properties = LoadPropertiesFile.handlePropertyFile("../Npf_Backend_Gateway/URI.properties");
		Forms forms = new Forms();
		forms.getCollegeConfigOptions(properties.getProperty("In1"),"Live");
	}

}

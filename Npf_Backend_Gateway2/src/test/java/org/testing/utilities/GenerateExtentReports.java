package org.testing.utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class GenerateExtentReports {
	
		public static ExtentReports generateExtentReport()
		{
			ExtentReports extentReports = new ExtentReports("../Npf_Backend_Gateway2/test-output/MS_Backend_Gateway_Report.html", false);
			return extentReports;
		}

}

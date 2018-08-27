package com.GimmalMIR.Utilities;

import java.util.HashMap;

public class ReadTestData {
	public static HashMap<String, String> readStepDefinationData(String arg1) {
		HashMap<String, String> testData = new HashMap<String, String>();
		// String arg1 = "EmployeeName:Hannah Flores::LeaveType:FMLA
		// US::FromDate:2018-04-01::ToDate:2018-04-01::";
		String[] test = arg1.split("::");

		for (int i = 0; i < test.length; i++) {
			String[] test2 = test[i].split(":");

			testData.put(test2[0], test2[1]);

		}
		return testData;
	}
}

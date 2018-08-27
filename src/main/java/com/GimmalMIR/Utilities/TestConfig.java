package com.GimmalMIR.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class TestConfig {
	public static HashMap<String, String> prjProperties = new HashMap<String, String>();

	public static HashMap<String, String> getConfigDetails() {
		try {

			String userdir = System.getProperty("user.dir");

			File file = new File(userdir + "\\src\\test\\resources\\Configuration\\Config.properties");

			FileInputStream fileinput = new FileInputStream(file);

			Properties prop = new Properties();

			prop.load(fileinput);

			for (String key : prop.stringPropertyNames()) {
				String value = prop.getProperty(key);
				prjProperties.put(key, value);

			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		return prjProperties;

	}
}

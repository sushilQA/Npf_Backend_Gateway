package org.testing.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class LoadPropertiesFile {
	
	public static Properties handlePropertyFile(String path) throws IOException
	{
		File file = new File(path);
		Properties properties = new Properties();
		FileReader fileReader = new FileReader(file);
		properties.load(fileReader);
		return properties;
		
	}

}

package Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Admin_Configmanager {

	
static String value;
	
	// String key will be passed whenever getPropertyValue method will be called.
	// Based on the key, its corresponding value will be fetched from property file

		public static String getPropertyValue(String key) throws IOException {
			
			File file = new File("flipkart_config.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);		
			value = properties.getProperty(key);			
			fileInput.close();		
			return value;		
		}
}

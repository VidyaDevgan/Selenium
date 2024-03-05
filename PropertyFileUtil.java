package commonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil {


			public String getDataFromPropertyFile(String keyname) throws IOException {
				// TODO Auto-generated method stub

				FileInputStream fils = new FileInputStream("src/test/resources/LoginCredentials.properties.txt");
				
				 Properties p = new Properties();
				
				p.load(fils);
				
				String val = p.getProperty(keyname);
				
				return val;
	}

}

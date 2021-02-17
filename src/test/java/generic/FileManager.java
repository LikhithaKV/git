package generic;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Reporter;

public class FileManager {

	 Properties pro;

	public FileManager() {
		
	try {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/env.properties");
	    pro = new Properties();
	    pro.load(fis);
		
	} catch (Exception e) {
		Reporter.log("failed to load properties from property file", true);
	}
	}
	
	public String getQatUrl() {
		String url = pro.getProperty("qat");
		if(url!=null)
			return url;
		else
			throw new RuntimeException("Failed to load url");
	}
	
	public String getProdUrl() {
		String url = pro.getProperty("prod");
		if(url!=null)
			return url;
		else
			throw new RuntimeException("Failed to load url");
	}
	
	public String getPreProdUrl() {
		String url = pro.getProperty("preProd");
		if(url!=null)
			return url;
		else
			throw new RuntimeException("Failed to load url");
	}
	
	public Long getImplicitWait() {
		String val = pro.getProperty("implicitwait");
		long time = Long.parseLong(val);
		return time;
		
	}

	public Long getTime() {
		String val = pro.getProperty("time");
		long time = Long.parseLong(val);
		return time;
		
	}
}

package generic;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	public Map<String, WebDriver> drivers=new HashMap<String, WebDriver>();
	
	public WebDriver getBrowser(String browsername) {
		WebDriver driver=null;
		switch (browsername) {
		case ("chrome"):
			 driver = drivers.get("chrome");
		if(driver==null) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			drivers.put("chrome", driver);
		}
		break;
		
		case ("firefox"):
			 driver = drivers.get("firefox");
		if(driver==null) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			drivers.put("firefox", driver);
		}
		break;
		
		case ("edge"):
			 driver = drivers.get("edge");
		if(driver==null) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			drivers.put("edge", driver);
		}
		break;
		
        default:
        	System.out.println("invalid browser");
			break;
		}
		return driver;
	}
}
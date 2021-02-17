package generic;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Screenshot {
public static String capture(WebDriver driver, String tcName) {
	String path=System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+tcName+".png";
	TakesScreenshot ts=(TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest = new File(path);
	try {
		FileHandler.copy(src, dest);
	} catch (Exception e) {
		Reporter.log("failed to take screenshot", true);
	}	
	return path;
}
}		

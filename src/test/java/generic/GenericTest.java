package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

    public class GenericTest {
	FileManager fm=new FileManager();
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
	 reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/report.html");
	 extent=new ExtentReports();
	 extent.attachReporter(reporter);
	 reporter.config().setDocumentTitle("regression version 1.0");
	 reporter.config().setReportName("liki");
	}
	
	@AfterSuite
	public void tearDown() {
		extent.setSystemInfo("os", "windows 10");
		test.assignAuthor("likhitha");
		test.assignDevice("laptop");
		test.assignCategory("web automation");
		extent.flush();
	}
	
	@BeforeMethod
	public void openApp() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get(fm.getProdUrl());
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeApp(ITestResult res ) {
		String tcName = res.getName();
		if(res.FAILURE==res.getStatus()) {
			System.out.println(tcName);
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(new Screenshot().capture(driver, tcName)).build());
			
		}
	driver.quit();	
	}

}

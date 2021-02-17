package generic;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Basepage {
	public  WebDriver driver;
	
	public Basepage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	public void verifyElement(int time,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element found",true);
	} catch (Exception e) {
		Reporter.log("Element not found",true);
		Assert.fail();
	}
}
	
	public void clickableElement(long time,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			System.out.println("element clickable");
		} catch (Exception e) {
			System.out.println("unable to click element");
			Assert.fail();
		}
	}
	
	public void verifyTab(int time,int NumberOfWindows) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.numberOfWindowsToBe(NumberOfWindows));
			System.out.println("child tab is present");
		} catch (Exception e) {
			System.out.println("child tab is not present");
			Assert.fail();
		}
	}
		
		public void mouseHover(WebElement element) {
			Actions act=new Actions(driver);
			act.moveToElement(element).perform();
		}
		
		public void rightClick(WebElement element) {
			Actions act=new Actions(driver);
			act.contextClick(element).perform();
		}
		
		public void verifyTitle(int seconds,String title)
		{
			WebDriverWait wait=new WebDriverWait(driver, seconds);
			
			try
			{
				wait.until(ExpectedConditions.titleContains(title));
				Reporter.log("title displayed",true);	
			}
			catch(Exception e)
			{
			Reporter.log("title not displayed",true);	
			Assert.fail();
			}
		}
		
		public void switchTab() {
			Set<String> windows = driver.getWindowHandles();
			for (String win : windows) {
				driver.switchTo().window(win);
			}
		}
}

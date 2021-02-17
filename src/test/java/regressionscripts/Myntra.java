package regressionscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.GenericTest;
import pom.BuyAnoukKurtaPage;
import pom.MyntrKurtasAndSuitsPage;
import pom.MyntraHomePage;

public class Myntra extends GenericTest{
    
	
	@Test
	public void buyMyntaProduct() {
	test=extent.createTest("Buy Myntra Product");
	test.generateLog(Status.INFO, "Buy myntra product test script started successfully");
	MyntraHomePage hp=new MyntraHomePage(driver);
    hp.clickWishlist();
    test.generateLog(Status.PASS, "successfully clicked on wishlist");
    hp.mouseHoverOnWomen();
    test.generateLog(Status.PASS, "successfully performed mouse hover action");
	hp.clickKurtas();
	test.generateLog(Status.PASS, "successfully clicked on kurtas");
	
	MyntrKurtasAndSuitsPage kp=new MyntrKurtasAndSuitsPage(driver);
	kp.clickAnoukKurta();
	test.generateLog(Status.PASS, "successfully clicked on anouk kurta");
	
	BuyAnoukKurtaPage bp=new BuyAnoukKurtaPage(driver);
	bp.verifyTab(6, 2);
	bp.switchTab();
	bp.selectSize();
	test.generateLog(Status.PASS, "successfully selected size");
	bp.addProdToCart();
	test.generateLog(Status.PASS, "successfully added product to cart");
	bp.clickBag();
	test.generateLog(Status.PASS, "successfully clicked on bag");	
	}
}

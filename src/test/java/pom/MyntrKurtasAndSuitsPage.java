package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Basepage;

public class MyntrKurtasAndSuitsPage extends Basepage {

	public MyntrKurtasAndSuitsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	@FindBy(xpath = "(//li[@class='product-base'])[15]")
	private WebElement anoukKurta;
	
	
	
	public void clickAnoukKurta() {
		verifyElement(5, anoukKurta);
		anoukKurta.click();
	}
	
}

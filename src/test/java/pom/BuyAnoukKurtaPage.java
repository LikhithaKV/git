package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Basepage;

public class BuyAnoukKurtaPage extends Basepage {

	public BuyAnoukKurtaPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "(//p[@class='size-buttons-unified-size'])[5]")
	private WebElement size;
	
	@FindBy(xpath = "//div[.='ADD TO BAG']")
	private WebElement addtocart;
	
	@FindBy(xpath = "//span[.='GO TO BAG']")
	private WebElement bag ;
	
	public void selectSize() {
		verifyElement(4, size);
		size.click();
	}
	
	public void addProdToCart() {
		clickableElement(7, addtocart);
		addtocart.click();
	}
	
	public void clickBag() {
		clickableElement(5, bag);
		bag.click();
	}
}

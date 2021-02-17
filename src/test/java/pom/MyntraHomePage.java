package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Basepage;
import generic.FileManager;

public class MyntraHomePage extends Basepage{

	public MyntraHomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//span[.='Wishlist']")
	private WebElement wishlist;
	
	@FindBy(xpath = "//a[.='Women']")
	private WebElement women;
	
	@FindBy(xpath = "//a[.='Kurtas & Suits']")
	private WebElement kurtas;
	
	public void clickWishlist() {
		verifyElement(15, wishlist);
		wishlist.click();
	}
	
	public void mouseHoverOnWomen() {
	verifyElement(7, women);
	mouseHover(women);	
	}
	
	public void clickKurtas() {
		clickableElement(5, kurtas);
		kurtas.click();
	}

}

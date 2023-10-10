package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Book {

	public WebDriver driver;
	
	@FindBy(xpath="//span[text()='Hindi Edition']//preceding ::span[text()='Shrimad Bhagwat Geeta Yatharoop']")
	WebElement book;
	
//	@FindBy(css="select#quantity") 
//	WebElement quantity_dropdown;
	
	@FindBy(xpath="//select[@id='quantity']")
	WebElement quantity_dropdown;
	
	@FindBy(css="input#add-to-cart-button")
	WebElement btn_cart;
	
	public Book(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchBook() {
		Actions act = new Actions(driver);
		act.moveToElement(book).build().perform();
		act.click(book).build().perform();
	}
	
	public void selectCount() {
		
		Select count = new Select(quantity_dropdown);
		count.selectByValue("4");
	}
	
	public void addCart() {
	//	btn_cart.click();
		Actions act = new Actions(driver);
		act.moveToElement(btn_cart).build().perform();
		act.click(btn_cart).build().perform();
	}
}

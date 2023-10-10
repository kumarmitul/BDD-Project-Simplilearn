package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {

	public WebDriver driver;
	
	@FindBy(css="a#nav-cart")
	WebElement cartBtn;
	
//    @FindBy(xpath="(//span[text()='Shrimad Bhagwat Geeta Yatharoop'])[1]")
//    WebElement itemName;
    
    @FindBy(xpath="(//span[@class='a-truncate sc-grid-item-product-title a-size-base-plus'])[1]/span[1]")
    WebElement itemName;
    
    @FindBy(xpath="//span[@class='a-dropdown-prompt']")
    WebElement number;
	
	public Cart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCart() {
		cartBtn.click();
	}
	
	public String verifyName() {
		String name = itemName.getText();
		return name;
	}
	
	public String verifyCount() {
		String count = number.getText();
		return count;
	}
	

	
}

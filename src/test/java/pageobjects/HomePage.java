
package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
//	Actions action = new Actions(driver);
	@FindBy(css="a#nav-link-accountList")
	WebElement accli;
	
	@FindBy(xpath="(//span[@class='nav-action-inner'])[1]")
	WebElement signin;
	
	@FindBy(xpath="//span[text()='Sign Out']")
	WebElement signout;
	
	@FindBy(css="nav-cart")
	WebElement cart;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void mouseHover() {
		Actions action =new Actions(driver);
		action.moveToElement(accli).build().perform();
	}
	
	public void btnClick() {
		Actions action = new Actions(driver);
		action.click(signin).build().perform();
	}
	
	public WebElement signoutButton(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(signout).build().perform();
	//	action.click(signout).build().perform();
		return signout;
	}
	
	public void clickLogout() {
		Actions action = new Actions(driver);
		action.moveToElement(signout).build().perform();
		action.click(signout).build().perform();
	}
	
	public void click_Cart() {
		cart.click();
	}
	
}

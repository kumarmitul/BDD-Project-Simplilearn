package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserId {

	public WebDriver driver;
	
	@FindBy(css="input#ap_email") 
	WebElement emailField;
	
	@FindBy(css="input#continue")
	WebElement cont;
	
	@FindBy(css="input#ap_password")
	WebElement passwordField;
	
	@FindBy(css="input#signInSubmit")
	WebElement btnSignIn;

	public UserId(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String name) {
		emailField.clear();
		emailField.sendKeys(name);
	}
	
	public void btnClick() {
		cont.click();
	}
	
	public void enterPassword(String name) {
		passwordField.clear();
		passwordField.sendKeys(name);
	}
	
	public void signIn() {
		btnSignIn.click();
	}
}

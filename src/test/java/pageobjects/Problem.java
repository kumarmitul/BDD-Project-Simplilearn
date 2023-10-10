package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Problem {

	public WebDriver driver;
	@FindBy(xpath = "//h4[contains(text(),'problem')]") WebElement problem_login;
	@FindBy(xpath ="//h4[contains(text(),'problem')]") WebElement problem_password;
	
	public Problem(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String loginIssue() {
		String issue = problem_login.getText();
		return issue;
	}
	
	public String passwordIssue() {
		String issue = problem_password.getText();
		return issue;
	}
}

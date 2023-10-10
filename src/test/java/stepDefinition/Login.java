/*
package stepDefinition;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.UserId;
import pageobjects.HomePage;
import pageobjects.Problem;

public class Login {

	public static WebDriver driver;
	HomePage home;
	UserId id;
	Problem prob;
	
	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	//	driver.get("https://amazon.in");
	}
	
	@Given("user is on homepage")
	public void user_is_on_homepage() {
	    
		driver.get("https://amazon.in");
		home = new HomePage(driver);
		home.mouseHover();
		home.btnClick();
		}

	@When("user enters username and password")
	public void user_enters_username_and_password(DataTable dataTable) {
	

		id = new UserId(driver);
		List<List<String>> data = dataTable.asLists(String.class); 
		
		String username = data.get(0).get(0);
		String pwd = data.get(0).get(1);
		id.enterUsername(username);
		id.btnClick();
		id.enterPassword(pwd);
		id.signIn();
	}

	@Then("user is navigated to homepage")
	public void user_is_navigated_to_homepage() {
		home = new HomePage(driver);
		home.mouseHover();
		WebElement logout = home.signoutButton(driver);
	
		if (logout.isDisplayed()) {
			System.out.println("User has logged in successfully");
		}
		else {
			System.out.println("Login is not done");
		}
	}

	@When("User enters invalid credentials")
	public void user_enters_invalid_credentials(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	   // throw new io.cucumber.java.PendingException();
		List<List<String>> data = dataTable.asLists(String.class); 
		
		String username1 = data.get(0).get(0);
	//	String pwd = data.get(0).get(1);
		id = new UserId(driver);
		id.enterUsername(username1);
		id.btnClick();
		prob = new Problem(driver);
		String issue_login = prob.loginIssue();
	//	id.enterPassword(pwd);
	//	id.signIn();
		
		
		if ((issue_login.contains("problem"))){
	//			|| (issue_password.contains("problem")))){
			System.out.println("User cannot login");
		}
		else {
			System.out.println("Login is complete");
		}
	//	WebElement emailField = driver.findElement(By.cssSelector("input#ap_email"));
	//	emailField.sendKeys(username);
	//	WebElement cont = driver.findElement(By.cssSelector("input#continue"));
	//	cont.click();
		
	//	WebElement passwordField = driver.findElement(By.cssSelector("input#ap_password"));
	//	passwordField.sendKeys(pwd);
	//	WebElement btnSignIn = driver.findElement(By.cssSelector("input#signInSubmit"));
	//	btnSignIn.click();
		String username2 = data.get(1).get(0);
		String pwd2 = data.get(1).get(1);
		id.enterUsername(username2);
		id.btnClick();
		id.enterPassword(pwd2);
		id.signIn();
		String issue_password = prob.passwordIssue();
		if ((issue_password.contains("problem"))){
			System.out.println("User cannot login");
			}
			else {
			System.out.println("Login is complete");
	}
}
	
	@Then("User does not login")
	public void user_does_not_login() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
	}

	@Then("Check the error message")
	public void check_the_error_message() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}
}
*/
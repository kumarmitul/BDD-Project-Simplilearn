/*
package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.UserId;
import pageobjects.HomePage;

public class VerifyCred {

	public static WebDriver driver;
	
	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Given("User launches the website")
	public void user_launches_the_website() {
	    
		driver.get("https://amazon.in");
		
		
		
	//	WebElement accli = driver.findElement(By.cssSelector("a#nav-link-accountList"));
	//	Actions action = new Actions(driver);
	//	action.moveToElement(accli).build().perform();
		HomePage driver_home = new HomePage(driver);
		driver_home.mouseHover();
		driver_home.btnClick();
		
	//	WebElement signin = driver.findElement(By.xpath("(//span[@class='nav-action-inner'])[1]"));
	//	action.click(signin).build().perform();
	}

	@When("User enters valid credentials")
	public void user_enters_valid_credentials(DataTable dataTable) {
		
		List<List<String>> data = dataTable.asLists(String.class); 
		
		String username = data.get(0).get(0);
		String pwd = data.get(0).get(1);
		
		UserId driver_userid = new UserId(driver);
	   // WebElement emailField = driver.findElement(By.cssSelector("input#ap_email"));
	//	emailField.sendKeys(username);
		driver_userid.enterUsername(username);
	//	WebElement cont = driver.findElement(By.cssSelector("input#continue"));
	//	cont.click();
		driver_userid.btnClick();
		
	//	WebElement passwordField = driver.findElement(By.cssSelector("input#ap_password"));
	//	passwordField.sendKeys(pwd);
		driver_userid.enterPassword(pwd);
	//	WebElement btnSignIn = driver.findElement(By.cssSelector("input#signInSubmit"));
	//	btnSignIn.click();
		driver_userid.signIn();
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	  //  throw new io.cucumber.java.PendingException();
	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		WebElement signout = driver.findElement(By.xpath("//span[text()='Sign Out']"));
	//	HomePage driver_new = new HomePage(driver);
		
	//	WebElement logout = driver_new.signoutButton(driver);
		if (signout.isDisplayed()) {
			System.out.println("User has logged in successfully");
		}
		else {
			System.out.println("Login is not done");
		}
	}

	@Then("Check the message")
	public void check_the_message() {
		
		WebElement ele = driver.findElement(By.xpath("//a[@id='nav-link-accountList']/div/span[contains(text(),'Hello,')]"));
		String expectedText = ele.getText();
		
		if (expectedText.contains("Hello")) {
			System.out.println("Login is successful");
		}
		else {
			System.out.println("Login failed");
		}
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
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
		
		String username = data.get(0).get(0);
		String pwd = data.get(0).get(1);
		
		WebElement emailField = driver.findElement(By.cssSelector("input#ap_email"));
		emailField.sendKeys(username);
		WebElement cont = driver.findElement(By.cssSelector("input#continue"));
		cont.click();
		
		WebElement passwordField = driver.findElement(By.cssSelector("input#ap_password"));
		passwordField.sendKeys(pwd);
		WebElement btnSignIn = driver.findElement(By.cssSelector("input#signInSubmit"));
		btnSignIn.click();
	    
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
		driver.close();
	}
}



@Given("user is on homepage")
public void user_is_on_homepage() {
    
}

@When("user enters username and password")
public void user_enters_username_and_password() {
   }

@When("clicks on signin button")
public void clicks_on_signin_button() {
    
}

@Then("user is navigated to homepage")
public void user_is_navigated_to_homepage() {
}
*/
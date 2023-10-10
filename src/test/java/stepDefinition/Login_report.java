package stepDefinition;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.UserId;
import pageobjects.HomePage;
import pageobjects.Problem;

public class Login_report {

	public static WebDriver driver;
	HomePage home;
	UserId id;
	Problem prob;

	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest logger;

	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get("https://amazon.in");

		extent = new ExtentReports();
		spark = new ExtentSparkReporter("./TestReport/ExtentSparkReport.html");
		spark.config().setTheme(Theme.DARK);
		extent.attachReporter(spark);
		logger = extent.createTest("Add product to cart");
		logger.info("Test case started");
		logger.pass("Browser opened");
	}

	@Given("user is on homepage")
	public void user_is_on_homepage() {

		driver.get("https://amazon.in");
		home = new HomePage(driver);
		home.mouseHover();
		home.btnClick();
		logger.pass("User is on Homepage");
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
		logger.pass("User enters username and password");
	}

	@Then("user is navigated to homepage")
	public void user_is_navigated_to_homepage() {
		home = new HomePage(driver);
		home.mouseHover();
		WebElement logout = home.signoutButton(driver);

		if (logout.isDisplayed()) {
			System.out.println("User has logged in successfully");
		} else {
			System.out.println("Login is not done");
		}
		logger.pass("Login is done");
	}

	/*
	 * @Then("Check the message") public void check_the_message() {
	 * 
	 * WebElement ele = driver.findElement(By.xpath(
	 * "//a[@id='nav-link-accountList']/div/span[contains(text(),'Hello,')]"));
	 * String expectedText = ele.getText();
	 * 
	 * if (expectedText.contains("Hello")) {
	 * System.out.println("Login is successful"); } else {
	 * System.out.println("Login failed"); } // Write code here that turns the
	 * phrase above into concrete actions // throw new
	 * io.cucumber.java.PendingException(); }
	 */
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
		// String pwd = data.get(0).get(1);
		id = new UserId(driver);
		id.enterUsername(username1);
		id.btnClick();
		prob = new Problem(driver);
		String issue_login = prob.loginIssue();
		// id.enterPassword(pwd);
		// id.signIn();

		if ((issue_login.contains("problem"))) {
			// || (issue_password.contains("problem")))){
			System.out.println("User cannot login");
		} else {
			System.out.println("Login is complete");
		}
		// WebElement emailField = driver.findElement(By.cssSelector("input#ap_email"));
		// emailField.sendKeys(username);
		// WebElement cont = driver.findElement(By.cssSelector("input#continue"));
		// cont.click();

		// WebElement passwordField =
		// driver.findElement(By.cssSelector("input#ap_password"));
		// passwordField.sendKeys(pwd);
		// WebElement btnSignIn =
		// driver.findElement(By.cssSelector("input#signInSubmit"));
		// btnSignIn.click();
		String username2 = data.get(1).get(0);
		String pwd2 = data.get(1).get(1);
		id.enterUsername(username2);
		id.btnClick();
		id.enterPassword(pwd2);
		id.signIn();
		String issue_password = prob.passwordIssue();
		if ((issue_password.contains("problem"))) {
			System.out.println("User cannot login");
		} else {
			System.out.println("Login is complete");
			logger.pass("Login failed with invalid credentials");
			Login_report.extent.flush();
		}
	}

	@Then("User does not login")
	public void user_does_not_login() {
	
		System.out.println("User could not login due to invalid credentials");
	}

	@Then("Check the error message")
	public void check_the_error_message() {
	
		System.out.println("Error message displayed due to invalid credentials");
	}

	@After
	public void closeBrowser() {
		// home = new HomePage(driver);
		// home.clickLogout();
		driver.quit();
	}
}

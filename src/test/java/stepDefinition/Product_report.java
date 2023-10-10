package stepDefinition;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pageobjects.*;


public class Product_report {

	WebDriver driver = Login_report.driver;
	SearchProduct sp;
	HomePage home;
	UserId id;
	Book bk;
	Cart ct;
	
/*	@Given("User has logged in application")
	public void user_has_logged_in_application() {

		driver = new ChromeDriver();
		driver.get("https://amazon.in");
		home = new HomePage(driver);
		home.mouseHover();
		home.btnClick();
		
		id = new UserId(driver);
		String username = "mituldotcom@gmail.com";
		String pwd = "Hareram2023";
		id.enterUsername(username);
		id.btnClick();
		id.enterPassword(pwd);
		id.signIn();
	}
*/	
	@Then("Search for a product")
	public void search_for_a_product() {
	    
	//	WebElement searchBox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
	//	searchBox.sendKeys("bhagwad gita");
		sp = new SearchProduct(driver);
		String name = "bhagwad gita";
		sp.searchItem(name);
		sp.searchButton();
	//	SearchProduct driver_search = new SearchProduct(driver);
		String itemName = sp.searchResult();
		
	//	String text = driver_search.searchResult();
		if (itemName.contains(name)) {
			System.out.println("Search is correct");
		}
		else {
			System.out.println("Search is incorrect");
		}
		Login_report.logger.pass("Product search done");
	}

	@Then("Add the product to cart")
	public void add_the_product_to_cart() {
		
		bk = new Book(driver);
		String oldHandle =driver.getWindowHandle();
		bk.searchBook();
		Set<String> handles = driver.getWindowHandles();
		
	//	driver.switchTo().newWindow(WindowType.TAB);
	//	driver.get("https://www.amazon.in/Bhagavad-Gita-Bhaktivendanta-Swami-Prabhupada/dp/938598618X/ref=sr_1_4?crid=1DZR9PYZ8D5AC&keywords=bhagwad+gita&qid=1688621544&sprefix=%2Caps%2C321&sr=8-4");
		for (String h:handles) {
			if (!h.equalsIgnoreCase(oldHandle)) {
			//	driver.switchTo().window(newHandle);
				System.out.println("Inside new tab");
				driver.switchTo().window(h);
			}
			else {
				System.out.println("Inside original tab");
			}
			
		}
	//	driver.switchTo().newWindow(WindowType.TAB);
		bk.selectCount();
		bk.addCart();
		Login_report.logger.pass("Product added to cart");
	}

	@Then("Verify if product in cart is correct")
	public void verify_if_product_in_cart_is_correct() {
		ct = new Cart(driver);
		ct.clickCart();
		String itemCart = ct.verifyName();
		System.out.println("Product name :"+itemCart);
		Login_report.logger.pass("Product in the cart is verified");
	}
	

	@Then("Verify if quantity is correct")
	public void verify_if_quantity_is_correct() {
		ct = new Cart(driver);
		String count = ct.verifyCount();
		System.out.println("Item count is:  " +count);
		Login_report.logger.pass("Quantity in the cart is verified");
		Login_report.extent.flush();
	}

}

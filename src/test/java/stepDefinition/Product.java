/*
package stepDefinition;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;

import pageobjects.*;


public class Product {

	WebDriver driver = Login.driver;
	SearchProduct sp;
	HomePage home;
	UserId id;
	Book bk;
	Cart ct;
	

	@When("Search for a product")
	public void search_for_a_product() {
	    
	//	WebElement searchBox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
	//	searchBox.sendKeys("bhagwad gita");
		sp = new SearchProduct(driver);
		String name = "bhagwad gita";
		sp.searchItem("bhagwad gita");
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
	//	driver.switchTo().window(oldHandle);
	}

	@Then("Verify if product in cart is correct")
	public void verify_if_product_in_cart_is_correct() {
		ct = new Cart(driver);
		ct.verifyName();
	}
	

	@Then("Verify if quantity is correct")
	public void verify_if_quantity_is_correct() {
		ct = new Cart(driver);
		ct.verifyCount();
	}

}
*/
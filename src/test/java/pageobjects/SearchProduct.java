package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct {

	public WebDriver driver;
	@FindBy(xpath="//input[@id='twotabsearchtextbox']") WebElement searchbox;
	@FindBy(xpath="(//span[contains(text(),'bhagwad gita')])[1]") WebElement searchText; 
	@FindBy(css="input#nav-search-submit-button") WebElement btn_search;
	
	public SearchProduct(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void searchItem(String item) {
		searchbox.sendKeys(item);
	}
	
	public void searchButton() {
		btn_search.click();
	}
	
	public String searchResult() {
		String item = searchText.getText();
		return item;
	}
}

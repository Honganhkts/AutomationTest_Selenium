package automation.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class SearchPageFactory_Tedu_Day15 {
	private WebDriver driver;
	@FindBy(xpath = "//input[@placeholder = 'Tìm bất cứ thứ gì mà bạn muốn']") WebElement searchInput;
	@FindBy(xpath="//input[@name='keyword']//following-sibling::span//button") WebElement searchButton;
	@FindBy(id="onesignal-slidedown-cancel-button") WebElement cancelButton;
	@FindBy(xpath = "//input[@value='Cập nhật']") WebElement updatePassbtn;
	
	public SearchPageFactory_Tedu_Day15(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}
	public void SearchFunction(String value) {	    
		searchInput.sendKeys(value);
		searchButton.click();}
		
	
	
}

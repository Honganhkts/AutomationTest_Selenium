package automation.page;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
public class LogoutPageFactory {
	public int initWaitTime = 30;

	private WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'Admin')]") WebElement drpMenu;
	@FindBy(xpath = "//button[text()='Đăng xuất' and @type='button']") WebElement logout;
	@FindBy(xpath = "//button[text()='Đăng xuất' and @type='submit']") WebElement btnSubmit;
	@FindBy(xpath = "//div[@class='toast-title]'") WebElement toastMSG;

	
	
	
	public LogoutPageFactory(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver,this);
	}
	public void LogoutFunction() {
			drpMenu.click();
			logout.click();
			btnSubmit.click();

	}

}

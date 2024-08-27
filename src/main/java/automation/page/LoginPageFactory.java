package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	private WebDriver driver;
	@FindBy(id="email") WebElement txtEmail;
	@FindBy(id = "password") WebElement txtPassword;
	@FindBy(name="signin") WebElement btnLogin;

	public LoginPageFactory(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver,this);
	}
	public void LoginFunction(String email, String pass) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(pass);
		btnLogin.click();
	}
	

}

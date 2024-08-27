package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory__Alada {
	private WebDriver driver;
	@FindBy(xpath = "//a[text()='Đăng Nhập']") WebElement btnDangNhapMenu;
	@FindBy(id="txtLoginUsername") WebElement txtLoginUsername;
	@FindBy(id="txtLoginPassword") WebElement txtLoginPassword;
	@FindBy(xpath = "//button[text()='ĐĂNG NHẬP' and @type='submit']") WebElement btnDangNhap;

	public LoginPageFactory__Alada(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver,this);
	}
	
	public void LoginFunction(String email, String pass) {
		btnDangNhapMenu.click();
		txtLoginUsername.sendKeys(email);
		txtLoginPassword.sendKeys(pass);
		btnDangNhap.click();
	}
}

package automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver _driver) {
		this.driver = _driver;
	}
	//xau dung ham dang nhap de su dung trong cac class test
	public void LoginFunction(String email, String password) {
		WebElement btnDangNhap = driver.findElement(By.xpath("//a[text()='Đăng Nhập']"));		
		if(btnDangNhap.isDisplayed())	btnDangNhap.click();
		
		WebElement textEmail = driver.findElement(By.id("txtLoginUsername"));
		textEmail.clear();
		if(textEmail.isDisplayed()) {
			textEmail.sendKeys(email);
		}
		
		WebElement textPassword = driver.findElement(By.id("txtLoginPassword"));
		textPassword.clear();
		if(textPassword.isDisplayed()) {
			textPassword.sendKeys(password);
		}
		
		WebElement btnLogin = driver.findElement(By.xpath("//button[text()='ĐĂNG NHẬP' and @type='submit']"));
		if(btnLogin.isDisplayed()) {
			btnLogin.click();
		}
	}
	
	
}

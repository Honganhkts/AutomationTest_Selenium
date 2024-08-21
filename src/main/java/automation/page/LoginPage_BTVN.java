package automation.page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage_BTVN {
	private WebDriver driver;

	public LoginPage_BTVN(WebDriver driver) {
		this.driver = driver;
	}
	public void loginFuntion_BTVN(String email, String password) {
		WebElement btnEmail = driver.findElement(By.id("email"));
		btnEmail.clear();
		if(btnEmail.isDisplayed()) {
			btnEmail.sendKeys(email);
		}
		
		WebElement btnPassword = driver.findElement(By.id("password"));
		btnPassword.clear();
		if(btnPassword.isDisplayed()) {
			btnPassword.sendKeys(password);
		}
		WebElement btnLogin = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
		if(btnLogin.isDisplayed()) {
			btnLogin.click();
		}
		
	}
	public void logoutFunction_BTVN() {
		WebElement drpAdmin = driver.findElement(By.xpath("//a[contains(text(),'Admin')]"));
		if(drpAdmin.isDisplayed()) drpAdmin.click();
		WebElement logout = driver.findElement(By.xpath("//button[text()='Đăng xuất' and @type='button']"));
		if(logout.isDisplayed()) logout.click();
		WebElement btnlogout = driver.findElement(By.xpath("//button[text()='Đăng xuất' and @type='submit']"));
		if(btnlogout.isDisplayed()) btnlogout.click();
		
		
		
	}
	
}

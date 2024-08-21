package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.LoginPage_BTVN;

public class Day13_BTVN_Login extends CommonBase {
	LoginPage_BTVN login;
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_CODESTAR_lOGIN);
	}
	@Test
	public void loginSuccessfully() {
		login = new LoginPage_BTVN(driver);
		login.loginFuntion_BTVN("admin@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//div[text()='Đăng nhập thành công!']")).isDisplayed());
	}
	@Test
	public void loginFail_EmailNotExist() {
		login = new LoginPage_BTVN(driver);
		login.loginFuntion_BTVN("admin111@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//span[text()='Email hoặc mật khẩu không đúng']")).isDisplayed());
	}
	@Test
	public void loginFail_PasswordInvalid() {
		login = new LoginPage_BTVN(driver);
		login.loginFuntion_BTVN("admin@gmail.com", "123");
		assertTrue(driver.findElement(By.xpath("//span[text()='Email hoặc mật khẩu không đúng']")).isDisplayed());
	}
	@Test
	public void loginFail_PasswordAndEmailInvalid() {
		login = new LoginPage_BTVN(driver);
		login.loginFuntion_BTVN("a123@gmail.com", "123");
		assertTrue(driver.findElement(By.xpath("//span[text()='Email hoặc mật khẩu không đúng']")).isDisplayed());
	}
	@Test
	public void loginFail_EmailWrongFormat() {
		login = new LoginPage_BTVN(driver);
		login.loginFuntion_BTVN("a123@gmail.com", "123");
		assertTrue(driver.findElement(By.xpath("//span[text()='Email hoặc mật khẩu không đúng']")).isDisplayed());
	}
	@Test
	public void loginFail_BlankEmail() {
		login = new LoginPage_BTVN(driver);
		login.loginFuntion_BTVN("", "12345678");
		assertTrue(driver.findElement(By.xpath("//span[text()='Email hoặc mật khẩu không đúng']")).isDisplayed());
	}
	@Test
	public void loginFail_BlankPassword() {
		login = new LoginPage_BTVN(driver);
		login.loginFuntion_BTVN("admin@gmail.com", "");
		assertTrue(driver.findElement(By.xpath("//span[text()='Email hoặc mật khẩu không đúng']")).isDisplayed());
	}
	@Test
	public void loginFail_BlankPasswordAndEmail() {
		login = new LoginPage_BTVN(driver);
		login.loginFuntion_BTVN("", "");
		assertTrue(driver.findElement(By.xpath("//span[text()='Email hoặc mật khẩu không đúng']")).isDisplayed());
	}
	@Test
	public void logout() {
		login = new LoginPage_BTVN(driver);
		login.loginFuntion_BTVN("admin@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//div[text()='Đăng nhập thành công!']")).isDisplayed());
		login.logoutFunction_BTVN();
		assertTrue(driver.findElement(By.xpath("//p[text()='Đăng nhập để truy cập vào hệ thống kho hàng']")).isDisplayed());
		
	}
	
}

package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.LoginPageFactory;
import automation.page.LogoutPageFactory;

public class LoginTestFactory extends CommonBase {
	LoginPageFactory loginFactory;
	LogoutPageFactory logoutFactory;

//ctrl A -> Ctrl + shift+F -> can le
	@BeforeMethod
	public void openFireFox() {
		driver = initFirefoxDriver(CT_PageURLs.URL_CODESTAR_lOGIN);
	}
	@Test
	public void LoginSuccessfully() {
		loginFactory = new LoginPageFactory(driver);
		loginFactory.LoginFunction("admin@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
	}
	
	@Test
	public void loginFail_PassIncorrect() {
		loginFactory = new LoginPageFactory(driver);
		loginFactory.LoginFunction("admin@gmail.com", "123_incorrect");
		assertTrue(driver.findElement(By.xpath("//h4[text()='Đăng nhập']")).isDisplayed());
	}
	@Test
	public void LogoutSuccessfully() throws InterruptedException {
		loginFactory = new LoginPageFactory(driver);
		loginFactory.LoginFunction("admin@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
		//logoutFactory = new LogoutPageFactory(driver);
		Thread.sleep(10000);
		logoutFactory = new LogoutPageFactory(driver);
		logoutFactory.LogoutFunction();
		assertTrue(driver.findElement(By.xpath("//p[text()='Đăng nhập để truy cập vào hệ thống kho hàng']")).isDisplayed());

	}
	

}

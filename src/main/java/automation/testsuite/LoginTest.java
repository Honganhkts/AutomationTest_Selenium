package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.LoginPage;

public class LoginTest extends CommonBase {
	LoginPage login;
	@BeforeMethod
	@Parameters("browser")
	public void initDriver(String browser) {
		setupDriver(browser);
		driver.get(CT_PageURLs.URL_ALADA);
	}
//	@BeforeMethod
//	public void openChrome() {
//		driver = initChromeDriver(CT_PageURLs.URL_ALADA);
//	}
	@Test
	public void loginSuccessfully() {
		login =  new LoginPage(driver);
		login.LoginFunction("honganhkts2610@gmail.com", "Honganh261021@");
		assertTrue(driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]")).isDisplayed());
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
//	@Test
//	public void loginFail_UsernameNotExist() {
//		login =  new LoginPage(driver);
//		login.LoginFunction("honganhkts0@gmail.com", "Honganh261021@");
//		assertTrue(driver.findElement(By.xpath("//p[text()='Email này chưa được đăng ký.']")).isDisplayed());
//		
//	}
//	@Test
//	public void loginFail_PasswordInvalid() {
//		login =  new LoginPage(driver);
//		login.LoginFunction("honganhkts2610@gmail.com", "1234");
//		assertTrue(driver.findElement(By.xpath("//p[text()='Mật khẩu sai.']")).isDisplayed());
//	}
//	@Test
//	public void loginFail_LeaveBlank() {
//		login =  new LoginPage(driver);
//		login.LoginFunction("", "");
//		assertTrue(driver.findElement(By.xpath("//label[text()='Vui lòng nhập email']")).isDisplayed());
//		assertTrue(driver.findElement(By.xpath("//label[text()='Vui lòng nhập mật khẩu']")).isDisplayed());
//
//	}
}

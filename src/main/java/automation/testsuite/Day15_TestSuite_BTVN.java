package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.LoginPageFactory_Tedu_Day15;
import automation.page.Register_PageFactory_Tedu_Day15;
import automation.page.SearchPageFactory_Tedu_Day15;
import automation.page.UpdatePassword_PageFactory_Day15;

public class Day15_TestSuite_BTVN extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_TEDU);
	}
//	@Test
//	public void RegisterSuccessfully() throws InterruptedException {
//		Register_PageFactory_Tedu_Day15 register = new Register_PageFactory_Tedu_Day15(driver);
//		register.RegisterPageFactoryFunction("Hoanh", "01-01-2001", "anhdth4@yopmail.com", "Honganh2610@");
//		assertTrue(driver.findElement( By.xpath("//span[text()='Tất cả khóa học']")).isDisplayed());
//		
//	}
	@Test(priority = 1)
	public void LoginSuccessfully() {
		LoginPageFactory_Tedu_Day15 login = new LoginPageFactory_Tedu_Day15(driver);
		login.LoginFunction("honganhkts2610@gmail.com", "Honganh1234");
		assertTrue(driver.findElement(By.xpath("//span[text()='Tất cả khóa học']")).isDisplayed());
	}
	@Test(priority = 2)
	public void UpdatePasswordSuccessfully() {
		String email = "honganhkts2610@gmail.com";
	    String currentPassword = "Honganh1234";
	    String newPassword = "Honganh12345";
	    LoginPageFactory_Tedu_Day15 login = new LoginPageFactory_Tedu_Day15(driver);
	    login.LoginFunction(email, currentPassword);
	    assertTrue(driver.findElement(By.xpath("//span[text()='Tất cả khóa học']")).isDisplayed());
	    UpdatePassword_PageFactory_Day15 updatePassword = new UpdatePassword_PageFactory_Day15(driver);
	    updatePassword.UpdatePassword(currentPassword, newPassword);
	    assertTrue(driver.findElement(By.xpath("//div[text()='Đổi mật khẩu thành công. Mời bạn đăng nhập lại.']")).isDisplayed());

	}
	@Test(priority = 3)
	public void SearchSuccessfully() {
		String email = "honganhkts2610@gmail.com";
	    String currentPassword = "Honganh12345";
	    LoginPageFactory_Tedu_Day15 login = new LoginPageFactory_Tedu_Day15(driver);
	    login.LoginFunction(email, currentPassword);
	    assertTrue(driver.findElement(By.xpath("//span[text()='Tất cả khóa học']")).isDisplayed());
		SearchPageFactory_Tedu_Day15 search = new SearchPageFactory_Tedu_Day15(driver);
		search.SearchFunction("ASP NET");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 assertTrue(driver.findElement(By.xpath("//a[contains(text(),'ASP NET')]")).isDisplayed());
	}

}

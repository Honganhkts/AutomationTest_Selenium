package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.ChangeInformationUserPageFactory_Alada;
import automation.page.LoginPageFactory;
import automation.page.LoginPageFactory__Alada;
import automation.page.RegisterPageFactory_Alada;

public class Day14_BTVN extends CommonBase {
	RegisterPageFactory_Alada register;
	LoginPageFactory__Alada login;
	ChangeInformationUserPageFactory_Alada ChangeInformationUser;
	//@BeforeMethod
	@BeforeMethod
	@Parameters("browser")
	public void initDriver ( @Optional("firefox")  String browser) {
		setupDriver(browser);
		driver.get(CT_PageURLs.URL_ALADA);
	}
//	public void openChrome() {
//		driver = initChromeDriver(CT_PageURLs.URL_ALADA);
//	}
	@Test(priority = 1)
	public void RegisterSuccessfully() throws InterruptedException {
		register = new RegisterPageFactory_Alada(driver);
		register.RegisterPageFactoryFunction("Hoanh","anhdth101121@yopmail.com", "anhdth101121@yopmail.com","Honganh2610!", "Honganh2610!","0121212121");
		Thread.sleep(5000);
		assertTrue(driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]")).isDisplayed());
	}
	@Test(priority = 2)
	public void ChangeInformationUserFunction() throws InterruptedException {
		login = new LoginPageFactory__Alada(driver);
		login.LoginFunction("anhdth10112@yopmail.com", "Honganh2610!");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		assertTrue(driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]")).isDisplayed());
		ChangeInformationUser  = new ChangeInformationUserPageFactory_Alada(driver);
		ChangeInformationUser.ChangeInformationUserFunction("Honganh2610!", "Honganh2610!1", "Honganh2610!1");

	}
	@Test(priority = 3)
	public void loginFunction() {
		login = new LoginPageFactory__Alada(driver);
		login.LoginFunction("anhdth101121@yopmail.com", "Honganh2610!");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		assertTrue(driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]")).isDisplayed());
		
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
		
}

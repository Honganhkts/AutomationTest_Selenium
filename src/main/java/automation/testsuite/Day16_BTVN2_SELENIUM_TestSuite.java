package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class Day16_BTVN2_SELENIUM_TestSuite extends CommonBase{
	@BeforeMethod
	public void openFireFox() {
		driver = initFirefoxDriver(CT_PageURLs.URL_SELENIUM_PRACTISE);
	}
	@Test(priority = 1)
	public void verifyAlertMessage()
	{
		click(By.xpath("//button[text()='Try it']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitAlertPeresent();
		String actualMessage = driver.switchTo().alert().getText();
		assertEquals(actualMessage, "Welcome to Selenium WebDriver Tutorials");
		driver.switchTo().alert().accept();
		assertTrue(driver.findElement(By.xpath("//h3[normalize-space(text())='Alert Demo']")).isDisplayed());
	}
	
}

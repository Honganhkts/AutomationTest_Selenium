package automation.testsuite;

import static org.testng.Assert.assertEquals;
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

public class Day16_BTVN3_GURU_TestSuite extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_GURU99_2);
	}
	@Test(priority = 1)
	public void verifyAlertMessage()
	{
		WebElement input = driver.findElement(By.name("cusid"));
		input.sendKeys("12345");
		click(By.name("submit"));
		waitAlertPeresent();
		driver.switchTo().alert().accept();
		String actualMessage = driver.switchTo().alert().getText();
		assertEquals(actualMessage, "Customer Successfully Delete!");
		waitAlertPeresent();
		driver.switchTo().alert().accept();
		assertTrue(driver.findElement(By.xpath("//td[text()='Delete Customer Form']")).isDisplayed());
	}
	
}

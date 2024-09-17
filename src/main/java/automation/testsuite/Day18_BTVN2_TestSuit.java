package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class Day18_BTVN2_TestSuit extends CommonBase{
	@BeforeMethod
	@Parameters("browser")
	public void initDriver(String browser) {
		setupDriver(browser);
		driver.get(CT_PageURLs.URL_BEPANTOAN);
	}
//	public void openChrome() {
//		driver = initChromeDriver(CT_PageURLs.URL_BEPANTOAN);
//	}
	@Test
	public void checkMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Chat với chúng tôi'])[1]/parent::a[@target='_blank']")));
		message.click();
		String mainWindow = driver.getWindowHandle();
		System.out.println("main window is: " + mainWindow);
		Set<String> listWindows = driver.getWindowHandles();
		for(String windowItem:listWindows) {
			System.out.println("windows is: " + windowItem);
			if(!windowItem.equals(mainWindow)) {
				driver.switchTo().window(windowItem);
				assertTrue(isElementVisibility(By.xpath("//h2[text()='Connect with your favourite people']")));
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		assertTrue(isElementVisibility(By.xpath("//span[text()='Danh mục sản phẩm']")));
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}

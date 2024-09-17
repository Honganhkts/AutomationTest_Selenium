package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class Day17_BTVN_TestSuite extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_MEDIAMART);
	}
	@Test
	public void handleIframeMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement iframeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='widget-preview--body']")));
		//driver.switchTo().frame(iframeMessage);
		WebElement btnGuiTinNhan = driver.findElement(By.xpath("//div[text()='Gửi tin nhắn']"));
		btnGuiTinNhan.click();
		assertTrue(isElementVisibility(By.xpath("//div[contains(text(),'chúng tôi không trực tuyến')]")));
	}
	@Test
	public void handleIframeZalo() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement iframeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='widget-preview--body']")));
		WebElement iconClose = driver.findElement(By.xpath("//div[@class='widget-preview--btn-close']"));
		iconClose.click();
		WebElement iframeZalo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='zalo-chat-widget']//iframe")));
		driver.switchTo().frame(iframeZalo);
		System.out.println("Switch tới iframe zalo thành công");
		click(By.xpath("//div[@class='logo']"));
		assertTrue(isElementVisibility(By.xpath("//p[contains(text(),'Bắt đầu trò chuyện')]")));
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}

package automation.common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonBase {
	public WebDriver driver;
	public int initWaitTime = 30;

	public WebDriver initChromeDriver(String URL) {
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(initWaitTime));
		return driver;
	}
	
	public WebDriver initFirefoxDriver(String URL) {
		FirefoxOptions options = new FirefoxOptions();
		System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(initWaitTime));
		return driver;
	}
	
	public WebElement getElementPresentDOM(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		return element;
	}
	
	public void clickJavaScriptToElement(By locator)
	{
		WebElement element = getElementPresentDOM(locator); // Thay thế cho driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
		js.executeScript("arguments[0].click();", element);
		}
		catch(StaleElementReferenceException ex)
		{
			pause(3000);
			clickJavaScriptToElement(locator);
		}
	}
	
	public void typeJavaScriptByValue (By locator, String text)
	{
		WebElement element = getElementPresentDOM(locator); // Thay thế cho driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
		js.executeScript("arguments[0].value= '" +text+ "'", element);
		}
		catch(StaleElementReferenceException ex)
		{
			pause(3000);
			typeJavaScriptByValue(locator, text);
		}
	}
	
	public void click(By locator) {
		WebElement element = getElementPresentDOM(locator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	public void type(By locator, String value) {
		WebElement element = getElementPresentDOM(locator);
		element.sendKeys(value);
	}
	
	public void scrollToElement(By locator)
	{
		WebElement element = getElementPresentDOM(locator); // Thay thế cho driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		catch(StaleElementReferenceException ex)
		{
			pause(5000);
			scrollToElement(locator);
		}
	}
	
	public void pause(int miliSecondInitWaitTime)
	{
		try {
			Thread.sleep(miliSecondInitWaitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void waitAlertPeresent()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public boolean isElementVisibility(By locator)
	{
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
		}
		catch(TimeoutException ex)
		{
			return false;
		}
	}
}

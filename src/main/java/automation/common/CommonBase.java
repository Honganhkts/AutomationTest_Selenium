package automation.common;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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
}

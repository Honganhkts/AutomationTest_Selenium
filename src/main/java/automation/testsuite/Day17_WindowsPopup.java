package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class Day17_WindowsPopup extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_GURU99_3);
	}
	@Test
	public void handleWindow() {
		click(By.xpath("//a[text()='Click Here']"));
		String mainWindow = driver.getWindowHandle();
		System.out.println("main window is: " + mainWindow);
		Set<String> listWindows = driver.getWindowHandles();
		for(String windowItem:listWindows) {
			System.out.print("windows is: " + windowItem);
			if(!windowItem.equals(mainWindow)) {
				driver.switchTo().window(windowItem);
				type(By.name("emailid"),"testdemo@yopmail.com");
				click(By.name("btnLogin"));
				assertTrue(isElementVisibility(By.xpath("//h2[text()='Access details to demo site.']")));
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		assertTrue(isElementVisibility(By.xpath("//a[text()='Click Here']")));
		}

}

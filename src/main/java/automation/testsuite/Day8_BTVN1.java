package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day8_BTVN1 extends CommonBase{
	@BeforeMethod
	public void openBrowser() {
	driver = initChromeDriver("https://selectorshub.com/xpath-practice-page/");
	}
	@Test
	public void getElementById() {
		WebElement txtUserMail = driver.findElement(By.name("email"));
		System.out.println(txtUserMail);
		
		WebElement password = driver.findElement(By.id("pass"));
		System.out.println(password);
		
		WebElement company = driver.findElement(By.name("company"));
		System.out.println(company);
		
		WebElement mobileNumber = driver.findElement(By.name("mobile number"));
		System.out.println(mobileNumber);


		WebElement buttonCheckout = driver.findElement(By.className("dropbtn"));
		System.out.println(buttonCheckout);
		
		WebElement pageMap = driver.findElement(By.tagName("canvas"));
		System.out.println(pageMap);
		
		WebElement partialLinkText = driver.findElement(By.partialLinkText("automate these controls"));
		System.out.println(partialLinkText);


	}
}

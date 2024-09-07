package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class HandleDatePicker_Day15 extends CommonBase {
	@BeforeMethod
	public void openFireFox() {
		driver = initFirefoxDriver(CT_PageURLs.URL_GURU99);
	}
	@Test
	public void inputBirthDay() {
		WebElement bdayText = driver.findElement(By.name("bdaytime"));
		bdayText.sendKeys("11204002 0900 AM");
		driver.findElement(By.xpath("//input[@type='submit']")).click();		
	}
	

}

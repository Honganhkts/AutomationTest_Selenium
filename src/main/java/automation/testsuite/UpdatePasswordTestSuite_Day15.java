package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.UpdatePassword_PageFactory_Day15;

public class UpdatePasswordTestSuite_Day15 extends CommonBase{
	@BeforeMethod
	public void openFireFox() {
		driver = initFirefoxDriver(CT_PageURLs.URL_TEDU);
	}
	@Test
	public void updatePasswordSuccessfully() {
		UpdatePassword_PageFactory_Day15 updatePass = new UpdatePassword_PageFactory_Day15(driver);
		updatePass.LoginFunction("honganhkts2610@gmail.com", "Honganh261021@");
//		WebElement btnAvatar = driver.findElement(By.id("my_account"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", btnAvatar);
		updatePass.UpdatePassword("Honganh261021@", "Honganh261021@_new");
	}

}

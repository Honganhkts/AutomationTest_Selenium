package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class Day12_BTVN  extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_SELENIUMEASY_4);
		
	}
	@Test
	public void case1_Dropdownlist_State() {
		Select dropdownState = new Select(driver.findElement(By.name("state")));
		//check size cua dropdownlist -> expected size = 52
		assertEquals(dropdownState.getOptions().size(),52);
		
		dropdownState.selectByVisibleText("Arkansas");
		assertEquals(dropdownState.getFirstSelectedOption().getText(),"Arkansas");
	}
	@Test
	public void case2_RadioButtonHosting() {
		WebElement btnYes = driver.findElement(By.xpath("//input[@value='yes' and @type='radio']"));
		WebElement btnNo = driver.findElement(By.xpath("//input[@value='no' and @type='radio']"));
		if(btnYes.isDisplayed()) {
			btnYes.click();
			assertTrue(btnYes.isSelected());
			assertFalse(btnNo.isSelected());

		}
		if(btnNo.isDisplayed()) {
			btnNo.click();
			assertTrue(btnNo.isSelected());
			assertFalse(btnYes.isSelected());

		}

	}

}

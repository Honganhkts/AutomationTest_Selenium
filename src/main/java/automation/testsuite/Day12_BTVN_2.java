package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class Day12_BTVN_2 extends CommonBase{
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_SELENIUMEASY_5);
		
	}
	@Test
	public void case1_Dropdownlist_State() {
		Select dropdown = new Select(driver.findElement(By.xpath("//select")));
		//check size cua dropdownlist -> expected size = 249
		assertEquals(dropdown.getOptions().size(),249);
		
		dropdown.selectByVisibleText("Liechtenstein");
		assertEquals(dropdown.getFirstSelectedOption().getText(),"Liechtenstein");
	}

}

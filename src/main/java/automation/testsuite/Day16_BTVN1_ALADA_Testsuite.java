package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.ChangeInformationUserPageFactory_Alada;
import automation.page.LoginPageFactory__Alada;

public class Day16_BTVN1_ALADA_Testsuite extends CommonBase{
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_ALADA);
	}
	@Test
	public void UpdatePasswordSuccessfull() {
		String mail = "anhdth10112@yopmail.com";
		String current_password = "Honganh2610";
		String new_password = "Honganh2611";
		LoginPageFactory__Alada login = new LoginPageFactory__Alada(driver);
		login.LoginFunction(mail, current_password);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		assertTrue(driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]")).isDisplayed());
		ChangeInformationUserPageFactory_Alada updatePassword = new ChangeInformationUserPageFactory_Alada(driver);
		updatePassword.ChangeInformationUserFunction(current_password, new_password, new_password);
		waitAlertPeresent();
		String actualMessage = driver.switchTo().alert().getText();
		assertEquals(actualMessage, "Cập nhật mật khẩu mới thành công!");
		driver.switchTo().alert().accept();
		String pageTitle = driver.getTitle();
		assertTrue(pageTitle==null|| pageTitle.isEmpty());
		
	}
	
}

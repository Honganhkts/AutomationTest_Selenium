package automation.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class Register_PageFactory_Tedu_Day15 {
	private WebDriver driver;
	@FindBy(xpath = "//a[text()='Đăng ký']") WebElement btnDangKyMenu;
	@FindBy(id="FullName") WebElement txtHoTen;
	@FindBy(id="DOB") WebElement txtNgaySinh;
	@FindBy(id="Email") WebElement txtEmail;
	@FindBy(id="Password") WebElement txtMatKhau;
	@FindBy(xpath = "//input[@value = 'Trở thành thành viên']") WebElement btnTroThanhThanhVien;
	@FindBy(id="onesignal-slidedown-cancel-button") WebElement cancelButton;
	public Register_PageFactory_Tedu_Day15(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}
	public void RegisterPageFactoryFunction(String hoTen, String ngaySinh, String email, String matKhau) throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        try {
	            wait.until(ExpectedConditions.visibilityOf(cancelButton));
	            cancelButton.click();
	        } catch (TimeoutException e) {
	        }
		btnDangKyMenu.click();
		txtHoTen.sendKeys(hoTen);
		txtNgaySinh.sendKeys(ngaySinh);
		txtEmail.sendKeys(email);
		txtMatKhau.sendKeys(matKhau);
		Thread.sleep(20000);
		btnDangKyMenu.click();
	}
}

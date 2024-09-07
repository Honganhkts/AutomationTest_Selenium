package automation.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class LoginPageFactory_Tedu_Day15 {
	private WebDriver driver;
	@FindBy(xpath="//a[text()='Đăng nhập']") WebElement btnDangNhapMenu;
	@FindBy(id="UserName") WebElement txtEmail;
	@FindBy(id="Password") WebElement txtMatKhau;
	@FindBy(xpath ="//label[@for='check']") WebElement checkGhiNhoMatKhau;
	@FindBy(xpath="//button[text()='Đăng nhập']") WebElement btnDangNhap;
	@FindBy(id="onesignal-slidedown-cancel-button") WebElement cancelButton;
	@FindBy(xpath = "//input[@value='Cập nhật']") WebElement updatePassbtn;

	public LoginPageFactory_Tedu_Day15(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver,this);
	}
	public void LoginFunction(String email, String matKhau) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        try {
	            wait.until(ExpectedConditions.visibilityOf(cancelButton));
	            cancelButton.click();
	        } catch (TimeoutException e) {
	        }
	        wait.until(ExpectedConditions.elementToBeClickable(btnDangNhapMenu));
	        btnDangNhapMenu.click();
	        wait.until(ExpectedConditions.visibilityOf(txtEmail));
	        txtEmail.sendKeys(email);
	        txtMatKhau.sendKeys(matKhau);
	        wait.until(ExpectedConditions.elementToBeClickable(btnDangNhap));
	        btnDangNhap.click();
	    }
	}
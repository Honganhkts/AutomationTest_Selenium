package automation.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class UpdatePassword_PageFactory_Day15 {
	private WebDriver driver;
	@FindBy(id="UserName") WebElement txtEmail;
	@FindBy(id = "Password") WebElement txtPassword;
	@FindBy(xpath="//button[text()='Đăng nhập']") WebElement btnLogin;
	@FindBy(id="my_account") WebElement btnAvatar;
	@FindBy(xpath="//a[@title='Đổi mật khẩu']") WebElement btnUpdatePass;
	//old pass
	@FindBy(id="OldPassword") WebElement txtOldPass;
	@FindBy(id="NewPassword") WebElement txtNewPass;
	@FindBy(id="ConfirmNewPassword") WebElement txtConfirmNewPassword;
	@FindBy(id="onesignal-slidedown-cancel-button") WebElement cancelButton;
	@FindBy(xpath = "//input[@value='Cập nhật']") WebElement updatePassbtn;
	

	public UpdatePassword_PageFactory_Day15(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver,this);
	}
	public void LoginFunction(String email, String pass) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(pass);
		btnLogin.click();
	}
	public void UpdatePassword(String oldPass, String newPass) {
	     btnAvatar.click();
	     btnUpdatePass.click();
	     txtOldPass.sendKeys(oldPass);
	     txtNewPass.sendKeys(newPass);
	     txtConfirmNewPassword.sendKeys(newPass);
	     updatePassbtn.click();
	}
	  

	
}

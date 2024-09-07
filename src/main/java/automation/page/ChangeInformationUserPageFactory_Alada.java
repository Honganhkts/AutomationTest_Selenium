package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangeInformationUserPageFactory_Alada {
	private WebDriver driver;
	@FindBy(xpath = "//a[@class='fleft w100per headcate']") WebElement subUser;
	@FindBy(xpath ="//a[contains(text(), 'Chỉnh sửa thông tin')]") WebElement suaThongTin;
	@FindBy(id="txtpassword") WebElement txtPassword;
	@FindBy(id="txtnewpass") WebElement txtNewPassword;
	@FindBy(id="txtrenewpass") WebElement txtCNewPassword;
	@FindBy(xpath = "//button[text()='Lưu mật khẩu mới']") WebElement btnSavePassword;
	@FindBy(xpath = "//a[text()='Thoát']") WebElement thoat;
	public ChangeInformationUserPageFactory_Alada(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}
	public void ChangeInformationUserFunction(String password, String newPassword, String cNewPassword) {
		subUser.click();
		suaThongTin.click();
		txtPassword.sendKeys(password);
		txtNewPassword.sendKeys(newPassword);
		txtCNewPassword.sendKeys(cNewPassword);
		btnSavePassword.click();
		//subUser.click();
		//thoat.click();
		

	}

}

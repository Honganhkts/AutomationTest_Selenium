package automation.page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageFactory_Alada {
	private WebDriver driver;
	@FindBy(xpath = "//a[text()='Đăng Ký']") WebElement btnDangKyMenu;
	@FindBy(id="txtFirstname") WebElement txtHoTen;
	@FindBy(id="txtEmail") WebElement txtEmail;
	@FindBy(id="txtCEmail") WebElement txtCEmail;
	@FindBy(id="txtPassword") WebElement txtPassword;
	@FindBy(id="txtCPassword") WebElement txtCPassword;
	@FindBy(id="txtPhone") WebElement txtPhone;
	@FindBy(id="chkRight") WebElement cbxDongY;
	@FindBy(xpath="//button[text()='ĐĂNG KÝ' and @type='submit']") WebElement btnDangKy;
	public RegisterPageFactory_Alada(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver,this);
	}
	public void RegisterPageFactoryFunction(String hoTen, String email, String reEmail, String password, String rePassword, String phone ) {
		btnDangKyMenu.click();
		txtHoTen.sendKeys(hoTen);
		txtEmail.sendKeys(email);
		txtCEmail.sendKeys(reEmail);
		txtPassword.sendKeys(password);
		txtCPassword.sendKeys(rePassword);
		txtPhone.sendKeys(phone);
		if(cbxDongY.isSelected()==false) {
			cbxDongY.click();
			assertTrue(cbxDongY.isSelected());
		}
		btnDangKy.click();
	}

}
